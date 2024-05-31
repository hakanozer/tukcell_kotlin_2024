package com.example.homework10.ui

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.homework10.R
import com.example.homework10.adaptors.ToDoAdaptor
import com.example.homework10.databinding.ActivityHomeScreenBinding
import com.example.homework10.models.Todo
import com.example.homework10.services.TodoService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeScreen : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeScreenBinding
    private lateinit var todoAdaptor: ToDoAdaptor
    private lateinit var todoService:TodoService
    private var todoList = mutableListOf<Todo>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        todoService=TodoService(this)
        binding=ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userId = intent.getIntExtra("userId", -1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        todoAdaptor = ToDoAdaptor(this, todoList,::showUpdateTodoDialog, ::deleteTodo,::toggleTodo)
        binding.listView.adapter=todoAdaptor
        lifecycleScope.launch {
            todoList.addAll(todoService.getTodosByUserId(userId))
            todoAdaptor.notifyDataSetChanged()
        }

        binding.addButton.setOnClickListener {
            showAddTodoDialog(userId)
        }
    }


    private fun showAddTodoDialog(userId:Int) {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val editTextTask = dialogView.findViewById<EditText>(R.id.editTextTask)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setTitle("Add New Todo")

        builder.setPositiveButton("Add") { dialog, _ ->
            val task = editTextTask.text.toString()
            if (task.isNotEmpty()) {
                val newTodo = Todo(task = task, userId = userId)
                lifecycleScope.launch {
                    todoService.addTodo(userId, newTodo)
                    todoList.add(newTodo)
                    todoAdaptor.notifyDataSetChanged()
                }
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    private fun showUpdateTodoDialog(todo: Todo) {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val editTextTask = dialogView.findViewById<EditText>(R.id.editTextTask)
        editTextTask.setText(todo.task)

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        builder.setTitle("Update Todo")

        builder.setPositiveButton("Update") { dialog, _ ->
            val task = editTextTask.text.toString()
            if (task.isNotEmpty()) {
                todo.task = task
                lifecycleScope.launch {
                    todoService.updateTodo(todo)
                    todoAdaptor.notifyDataSetChanged()
                }



            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
    private fun deleteTodo(todo: Todo) {
        lifecycleScope.launch {
            todoService.deleteTodo(todo.id!!.toLong())
            todoList.remove(todo)
            todoAdaptor.notifyDataSetChanged()
        }

    }
    private fun toggleTodo(todo: Todo, isChecked: Boolean) {
        todo.completed = isChecked
        lifecycleScope.launch {
            todoService.updateTodo(todo)
            todoAdaptor.notifyDataSetChanged()
        }
    }


}