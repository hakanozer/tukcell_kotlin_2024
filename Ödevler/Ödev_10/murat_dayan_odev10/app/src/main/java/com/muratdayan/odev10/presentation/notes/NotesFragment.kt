package com.muratdayan.odev10.presentation.notes

/*Menu*/
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.muratdayan.odev10.R
import com.muratdayan.odev10.common.components.UserSharedPrefManager
import com.muratdayan.odev10.common.utils.showSnackbar
import com.muratdayan.odev10.databinding.FragmentNotesBinding
import com.muratdayan.odev10.models.Note
import com.muratdayan.odev10.presentation.adapters.ItemListeners
import com.muratdayan.odev10.presentation.adapters.NotesAdapter
import com.muratdayan.odev10.services.NoteService


class NotesFragment : Fragment(), ItemListeners {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var userSharedPrefManager: UserSharedPrefManager
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var noteService: NoteService
    private var note: Note? = null
    private val nids = mutableListOf<Int>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)

        notesAdapter = NotesAdapter(this)
        binding.rvNotes.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = notesAdapter
        }
        // viewmodel create
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        noteService = NoteService(requireContext())
        notesViewModel.getAllNotes(noteService)

        notesViewModel.sortedNotes.observe(viewLifecycleOwner) { noteList ->
            notesAdapter.submitList(noteList)
            Log.d("NotesFragment", "Notes list updated: $noteList")
        }

        // nids listesi silinecek notları tutar uzun basma işlemine göre
        notesViewModel.isLongPressed.observe(viewLifecycleOwner) { isLongPressed ->
            if (isLongPressed == false) {
                nids.clear()
            }
        }

        // issearched boolean nesnesini izler ve true oldugunda arama işlemi yapılır
        notesViewModel.isSearched.observe(viewLifecycleOwner) { isSearched ->
            if (isSearched) {
                binding.txtInpLayoutSearch.endIconMode = TextInputLayout.END_ICON_CUSTOM
                binding.txtViewTitle.visibility = View.GONE
                binding.txtInpLayoutSearch.visibility = View.VISIBLE
                binding.editTxtSearch.visibility = View.VISIBLE
                binding.txtInpLayoutSearch.setEndIconOnClickListener {
                    binding.editTxtSearch.text?.clear()
                    notesViewModel.getAllNotes(noteService)
                    binding.txtInpLayoutSearch.endIconMode = TextInputLayout.END_ICON_NONE
                    notesViewModel.searchOpenControl(false)
                }
            } else {
                binding.txtInpLayoutSearch.endIconMode = TextInputLayout.END_ICON_NONE
                notesViewModel.getAllNotes(noteService)
                binding.txtViewTitle.visibility = View.VISIBLE
                binding.txtInpLayoutSearch.visibility = View.GONE
                binding.editTxtSearch.visibility = View.GONE
            }
        }

        // uzun basma işlemini observe eder ve true ise arama componentları visible eder
        notesViewModel.isLongPressed.observe(viewLifecycleOwner) { isLongPressed ->
            if (isLongPressed) {
                binding.txtInpLayoutSearch.visibility = View.INVISIBLE
                binding.imgViewSearchIcon.visibility = View.INVISIBLE
                binding.imgViewFilterIcon.visibility = View.INVISIBLE
                binding.chBoxIsDone.visibility = View.VISIBLE
                binding.imgViewDeleteIcon.visibility = View.VISIBLE

            } else {
                binding.txtInpLayoutSearch.visibility = View.VISIBLE
                binding.imgViewSearchIcon.visibility = View.VISIBLE
                binding.imgViewFilterIcon.visibility = View.VISIBLE
                binding.chBoxIsDone.visibility = View.INVISIBLE
                binding.imgViewDeleteIcon.visibility = View.INVISIBLE

            }
        }

        binding.fabEdit.setOnClickListener {
            findNavController().navigate(R.id.navigate_notesFragment_to_notesAddEditFragment)
        }

        binding.imgViewDeleteIcon.setOnClickListener {
            val nidsIntArray = nids.toIntArray()
            if (nids.isNotEmpty()) {
                notesViewModel.deleteNote(noteService, *nidsIntArray)
            }
            notesViewModel.longPressedFinished()
        }

        binding.imgViewSearchIcon.setOnClickListener {
            notesViewModel.searchOpenControl(true)
            val searchText = binding.editTxtSearch.text.toString().trim()
            if (searchText.isNotEmpty()) {
                notesViewModel.searchNote(noteService, searchText)
            }
        }

        binding.imgViewLogoutIcon.setOnClickListener {
            userSharedPrefManager = UserSharedPrefManager(requireActivity())

            it.showSnackbar("are you sure you want to log out", "Yes") {
                userSharedPrefManager.deleteUser()
                findNavController().navigate(R.id.navigate_notesFragment_to_loginFragment)
            }
        }

        // notları önem derecesine göre sıralar
        binding.imgViewFilterIcon.setOnClickListener {
            notesViewModel.sortNotesByPriority(noteService)
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        notesViewModel.longPressedFinished()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLongItemClick(note: Note) : Boolean {
        this.note = note
        nids.add(note.nid)
        notesViewModel.longPressed()

        if (note.isDone == 1) {
            binding.chBoxIsDone.isChecked = true
        } else {
            binding.chBoxIsDone.isChecked = false
        }

        binding.chBoxIsDone.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                notesViewModel.updateNote(noteService, note, 1)
                notesViewModel.longPressedFinished()
            } else {
                notesViewModel.updateNote(noteService, note, 0)
                notesViewModel.longPressedFinished()
            }
        }

        return  notesViewModel.isLongPressed.value ?:true
    }

    override fun onItemClick(note: Note) :Boolean {
        if (nids.isEmpty()) {
            val navigateNoteEdit =
                NotesFragmentDirections.navigateNotesFragmentToNotesAddEditFragment(note)
            findNavController().navigate(navigateNoteEdit)
        } else {
            notesViewModel.longPressedFinished()
        }

        return  notesViewModel.isLongPressed.value ?:false
    }


}