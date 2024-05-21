package com.toren.vize3.presentation.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.toren.vize3.R
import com.toren.vize3.common.Constants
import com.toren.vize3.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {

    lateinit var binding: ActivityFilterBinding

    companion object {
        var filter: Pair<String, String>? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val components =
            listOf(binding.nameETxt, binding.surnameETxt, binding.ageETxt, binding.bloodGroupTw)

        components.forEach { component ->
            component.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(text: Editable?) {
                    if (text.toString().isNotEmpty()) {
                        filter = Pair(component.tag.toString(), text.toString())
                        components.filter { it != component }.forEach { it.isEnabled = false }
                    } else {
                        if (components.all { it.text.toString().isEmpty() }) {
                            components
                                .filter { it.id != R.id.bloodGroupTw }
                                .forEach { it.isEnabled = true }
                        }
                    }
                }

            })
        }
        val popupMenu = PopupMenu(this, binding.bloodGroupTw)
        popupMenu.menuInflater.inflate(R.menu.blood_group_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.none -> {
                    setBloodGroup("")
                    true
                }

                R.id.blood_group_ab_negative -> {
                    setBloodGroup("AB-")
                    true
                }

                R.id.blood_group_ab_positive -> {
                    setBloodGroup("AB+")
                    true
                }

                R.id.blood_group_a_negative -> {
                    setBloodGroup("A-")
                    true
                }

                R.id.blood_group_a_positive -> {
                    setBloodGroup("A+")
                    true
                }

                R.id.blood_group_b_negative -> {
                    setBloodGroup("B-")
                    true
                }

                R.id.blood_group_b_positive -> {
                    setBloodGroup("B+")
                    true
                }

                R.id.blood_group_o_negative -> {
                    setBloodGroup("O-")
                    true
                }

                R.id.blood_group_o_positive -> {
                    setBloodGroup("O+")
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.bloodGroupExpandBtn.setOnClickListener{
            popupMenu.show()
        }


        binding.backBtn.setOnClickListener {

            finish()
        }
    }

    private fun setBloodGroup(bloodGroup: String) = binding.bloodGroupTw.setText(bloodGroup)


}