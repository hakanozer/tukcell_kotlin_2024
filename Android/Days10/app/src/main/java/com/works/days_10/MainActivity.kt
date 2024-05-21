package com.works.days_10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.works.days_10.adapters.PostAdapter
import com.works.days_10.datas.DummyUsers

class MainActivity : AppCompatActivity() {

    lateinit var postList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        postList = findViewById(R.id.postList)
        postList.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)

        val posts = DummyUsers.getUsers().posts
        val adapter = PostAdapter(posts)
        postList.adapter = adapter

    }
}