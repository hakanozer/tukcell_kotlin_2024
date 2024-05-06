package com.tlh.deneme


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private lateinit var dataButton: Button
    private lateinit var intentText: TextView
    private lateinit var rootView: View
    private var receivedData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_2)

        dataButton = findViewById(R.id.button4)
        intentText = findViewById(R.id.textView)
        rootView = findViewById(android.R.id.content)

        receivedData = intent.getStringExtra("NamePassed")
        intentText.text = receivedData

        dataButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Do you want to get data")
            builder.setMessage("This is a message")

            builder.setPositiveButton("Yes") { dialog, which ->
                val snackbar = Snackbar.make(rootView, "Force may be with you", Snackbar.LENGTH_LONG)
                snackbar.show()
                 XmlService().xmlLoad()
            }

            builder.setNegativeButton("No") { dialog, which ->
                //
            }

            val dialog = builder.create()
            dialog.show()
        }
    }
}
