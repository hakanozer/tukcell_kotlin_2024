package com.example.homework10.adaptors

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import com.example.homework10.R
import com.example.homework10.models.Todo

class ToDoAdaptor(
    private val context: Activity,
    private var arr: List<Todo>,
    private val onEdit: (Todo) -> Unit,
    private val onDelete: (Todo) -> Unit,
    private val onToggle: (Todo, Boolean) -> Unit
) : ArrayAdapter<Todo>(context, R.layout.todo_row, arr) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.todo_row, null, true)
        val dt = arr[position]

        val r_row = rootView.findViewById<TextView>(R.id.r_todo)
        r_row.text = dt.task

        val checkBox = rootView.findViewById<CheckBox>(R.id.checkBox)
        checkBox.isChecked = dt.completed
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            onToggle(dt, isChecked)
        }



        val editButton = rootView.findViewById<ImageButton>(R.id.editButton)
        val deleteButton = rootView.findViewById<ImageButton>(R.id.deleteButton)

        editButton.setOnClickListener {
            onEdit(dt)
        }

        deleteButton.setOnClickListener {
            onDelete(dt)
        }

        return rootView
    }
}
