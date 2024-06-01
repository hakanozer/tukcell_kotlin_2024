package com.tlh.foodrecipe.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.tlh.foodrecipe.databinding.FragmentRecipeBinding
import com.tlh.foodrecipe.model.Recipe
import com.tlh.foodrecipe.room.RecipeDao
import com.tlh.foodrecipe.room.RecipeDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.ByteArrayOutputStream
import java.io.IOException


class RecipeFragment : Fragment() {
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private var selectedImage: Uri? = null
    private var selectedImageBitmap: Bitmap? = null
    private lateinit var db: RecipeDatabase
    private lateinit var dao: RecipeDao
    private val mDisposable = CompositeDisposable() // if we want to dispose the subscription
    private var chosenRecipe: Recipe? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLauncher()

        db = Room.databaseBuilder(requireContext(), RecipeDatabase::class.java, "Recipes").build()
        dao = db.recipeDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener { save(it) }
        binding.deleteButton.setOnClickListener { delete(it) }
        binding.imageView.setOnClickListener { selectImage(it) }
        registerLauncher()
        arguments.let {
            val info = RecipeFragmentArgs.fromBundle(it!!).info
            if (info == "new") {
                chosenRecipe = null
                binding.saveButton.isEnabled = true
                binding.deleteButton.isEnabled = false
            } else {
                binding.saveButton.isEnabled = false
                binding.deleteButton.isEnabled = true
                val id = RecipeFragmentArgs.fromBundle(it).id

                mDisposable.add(
                    dao.getById(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleResponseForReturnOne)
                )


            }
        }
    }

    private fun handleResponseForReturnOne(recipe: Recipe) {
        val bitmap = BitmapFactory.decodeByteArray(recipe.recipeImage, 0, recipe.recipeImage.size)
        binding.foodName.setText(recipe.recipeName)
        binding.ingredientsText.setText(recipe.recipeIngredients)
        binding.imageView.setImageBitmap(bitmap)
        chosenRecipe = recipe
    }


    private fun save(view: View) {
        val name = binding.foodName.text.toString()
        val ingredients = binding.ingredientsText.text.toString()

        if (selectedImageBitmap != null) {
            val lowerBitmap = createdBitmap(selectedImageBitmap!!, 300)
            val outputStream = ByteArrayOutputStream() // convert bitmap to byte array
            lowerBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val byteArray = outputStream.toByteArray()

            val recipe = Recipe(name, ingredients, byteArray)
            mDisposable.add(
                dao.insert(recipe)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponseForInsert)
            )
        }
    }

    private fun handleResponseForInsert() {
        // turn back to previous fragment
        val action = RecipeFragmentDirections.actionRecipeFragmentToListFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun delete(view: View) {
        if (chosenRecipe != null) {
            dao.delete(recipe = chosenRecipe!!)
            mDisposable.add(
                dao.delete(recipe = chosenRecipe!!)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponseForInsert)

            )
        }
    }

    private fun selectImage(view: View) {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.READ_MEDIA_IMAGES
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // has not been granted yet, we need to request it
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(), Manifest.permission.READ_MEDIA_IMAGES
                    )
                ) {
                    Snackbar.make(
                        view,
                        "We need your permission to access your gallery",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("Give Permission", View.OnClickListener {
                        //We request the permission
                        permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)

                    }

                    ).show()

                } else {
                    //We request permission
                    permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
                }
            } else {
                //Request has been approved we can navigate to gallery
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)

            }
        } else {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // has not been granted yet, we need to request it
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    Snackbar.make(
                        view,
                        "We need your permission to access your gallery",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("Give Permission", View.OnClickListener {
                        //We request the permission
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                    }

                    ).show()

                } else {
                    //We request permission
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            } else {
                //Request has been approved we can navigate to gallery
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)

            }
        }


    }

    private fun registerLauncher() {
        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == AppCompatActivity.RESULT_OK) {
                    val intentFromResult = result.data
                    if (intentFromResult != null) {
                        selectedImage = intentFromResult.data
                        try {
                            if (Build.VERSION.SDK_INT >= 28) {
                                val source = ImageDecoder.createSource(
                                    requireActivity().contentResolver, selectedImage!!
                                )
                                selectedImageBitmap = ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(selectedImageBitmap)
                            } else {
                                selectedImageBitmap = MediaStore.Images.Media.getBitmap(
                                    requireContext().contentResolver, selectedImage
                                )
                                binding.imageView.setImageBitmap(selectedImageBitmap)
                            }
                        } catch (e: IOException) {
                            println(e.localizedMessage)
                        }
                    }
                }
            }

        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
                if (result) {
                    //permission granted
                    //we can go to the gallery
                    val intentToGallery =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intentToGallery)
                } else {
                    //permission has not been granted
                    Toast.makeText(requireContext(), "Permission needed", Toast.LENGTH_LONG)
                        .show()
                }

            }
    }

    private fun createdBitmap(userBitmap: Bitmap, maxImageSize: Int): Bitmap {

        var width = userBitmap.width
        var height = userBitmap.height
        val bitmapRate = width.toDouble() / height.toDouble()
        if (bitmapRate > 1) {
            width = maxImageSize
            val lowerHeight = (width / bitmapRate).toInt()
            height = lowerHeight
        } else {
            height = maxImageSize
            val lowerWidth = (height * bitmapRate).toInt()
            width = lowerWidth
        }

        return Bitmap.createScaledBitmap(userBitmap, width, height, true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mDisposable.clear()//perform cleanup
    }
}