package com.works.days_5

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.days_5.components.CustomToast

class MainActivity : AppCompatActivity() {
    
    lateinit var btnAlert: Button
    lateinit var btnConfirm: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        btnAlert = findViewById(R.id.btnAlert)
        btnConfirm = findViewById(R.id.btnConfirm)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAlert.setOnClickListener {
            CustomToast(this, "Error","Customer Data Error!", 5000).show()
        }

        btnConfirm.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete")
            builder.setMessage("Are you sure!")

            builder.setPositiveButton("Yes") { dialog, wich ->
                Log.d("builder", "Yes Click")
            }

            builder.setNegativeButton("No") { dialog, wich ->
                Log.d("builder", "No Click")
            }

            builder.setNeutralButton("Cancel") { dialog, wich ->
                Log.d("builder", "Cancel Click")
            }

            builder.setCancelable(false)
            val alert = builder.create()
            alert.show()
        }

    }
}