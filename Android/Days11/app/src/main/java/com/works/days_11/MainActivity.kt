package com.works.days_11

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_11.services.ContactService

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val contactService = ContactService(this)
        //val status = contactService.addContanct("Erdal", "Bilki", 35, "red")
        //Log.d("addContanct", "$status")

        //val deleteStatus = contactService.deleteContanct(3)
        //Log.d("deleteStatus", "$deleteStatus")

        //val updateStatus = contactService.updateContanct("Zehra", "Bilsin", 25, "black", 4)
        //Log.d("updateStatus", "$updateStatus")

        //val arr = contactService.allContanct()

        /*
        val arr = contactService.searchContanct("sin")
        for (item in arr) {
            Log.d("item", item.toString())
        }
         */

        val item = contactService.singleContanct("Zehra","Bilsin")
        Log.d("single", item.toString())

    }
}