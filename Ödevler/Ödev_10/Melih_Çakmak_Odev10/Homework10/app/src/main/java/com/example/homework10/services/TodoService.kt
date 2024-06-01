package com.example.homework10.services

import android.content.ContentValues
import android.content.Context
import com.example.homework10.configs.ToDoDatabaseHelper
import com.example.homework10.models.Todo
import com.example.homework10.models.User

class TodoService(context:Context):ToDoDatabaseHelper(context) {

    fun addTodo(userID: Int, todo: Todo): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_TASK, todo.task)
            put(COLUMN_COMPLETED, if (todo.completed) 1 else 0)
            put(COLUMN_USER_ID,userID)
        }
        return db.insert(TABLE_TODOS, null, contentValues)
    }

    fun updateTodo(todo: Todo) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_TASK, todo.task)
            put(COLUMN_COMPLETED, if (todo.completed) 1 else 0)
            put(COLUMN_USER_ID,todo.userId)
        }
        db.update(TABLE_TODOS, contentValues, "$COLUMN_ID=?", arrayOf(todo.id.toString()))
    }

    fun deleteTodo(todoId: Long) {
        val db = this.writableDatabase
        db.delete(TABLE_TODOS, "$COLUMN_ID=?", arrayOf(todoId.toString()))
    }

    fun getTodosByUserId(userId: Int): List<Todo> {
        val todos = mutableListOf<Todo>()
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_TODOS,
            null,
            "$COLUMN_USER_ID=?",
            arrayOf(userId.toString()),
            null,
            null,
            null
        )
        if (cursor.moveToFirst()) {
            do {
                val todo = Todo(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    task = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK)),
                    completed = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_COMPLETED)) > 0,
                    userId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID))
                )
                todos.add(todo)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return todos
    }





}