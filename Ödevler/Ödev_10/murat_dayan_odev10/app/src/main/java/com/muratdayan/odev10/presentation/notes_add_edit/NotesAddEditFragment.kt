package com.muratdayan.odev10.presentation.notes_add_edit

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.muratdayan.odev10.R
import com.muratdayan.odev10.common.components.CustomToast
import com.muratdayan.odev10.databinding.FragmentNotesAddEditBinding
import com.muratdayan.odev10.services.NoteService
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class NotesAddEditFragment : Fragment() {

    private var _binding: FragmentNotesAddEditBinding? = null
    private val binding get() = _binding!!
    private var priorityValue: Int = 3
    private val args: NotesAddEditFragmentArgs by navArgs()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNotesAddEditBinding.inflate(inflater, container, false)

        val noteService = NoteService(requireContext())


        val noteArg = args.noteData

        // arguman olarak gelen note boş değilse gerekli yerleri mevcut note bilgisiyle doldurur
        noteArg?.let {
            binding.editTxtTitle.setText(it.title)
            binding.editTxtDetail.setText(it.detail)

            when (noteArg.priority) {
                1 -> binding.rbImportant.isChecked = true
                2 -> binding.rbNormal.isChecked = true
                3 -> binding.rbLow.isChecked = true
            }
        }


        // Seçilen alanları kontrol eder ve notu ekler veya update eder
        binding.imgDoneIcon.setOnClickListener {
            val title = binding.editTxtTitle.text.toString().trim()
            val detail = binding.editTxtDetail.text.toString().trim()

            val selectedOption: Int = binding.radioGroup.checkedRadioButtonId


            if (selectedOption != -1) {
                val selectedRadioButton = binding.radioGroup.findViewById<View>(selectedOption)
                when (selectedRadioButton.id) {
                    binding.rbImportant.id -> priorityValue = 1
                    binding.rbNormal.id -> priorityValue = 2
                    binding.rbLow.id -> priorityValue = 3
                    else -> priorityValue = 3
                }
            }

            if (title.isNotEmpty() && detail.isNotEmpty()) {
                val today: LocalDate = LocalDate.now()
                val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
                val dateString: String = today.format(dateFormatter)
                if (noteArg == null) {

                    val insertStatus = noteService.addNote(title, detail, priorityValue, dateString,0)
                    if (insertStatus != 0.toLong()) {
                        findNavController().navigate(R.id.navigate_notesAddEditFragment_to_notesFragment)
                    }

                } else {
                    val updateStatus =
                        noteService.updateNote(
                            noteArg.nid,
                            title,
                            detail,
                            priorityValue,
                            dateString,
                            noteArg.isDone
                        )
                    if (updateStatus != 0) {
                        findNavController().navigate(R.id.navigate_notesAddEditFragment_to_notesFragment)
                    }
                }
            }else{
                CustomToast(requireActivity(),"Please Fill in all the fields",Toast.LENGTH_SHORT).show()
            }
        }

        binding.imgBackIcon.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    // binding lifecycle bbittiğinde null olur
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}