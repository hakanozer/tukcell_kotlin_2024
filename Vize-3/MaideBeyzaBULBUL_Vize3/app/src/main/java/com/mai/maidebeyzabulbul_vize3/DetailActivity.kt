package com.mai.maidebeyzabulbul_vize3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mai.maidebeyzabulbul_vize3.models.User
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getSerializableExtra("user") as? User

        if (user != null) {
            val userImage: ImageView = findViewById(R.id.userImage)
            val userName: TextView = findViewById(R.id.userName)
            val userAge: TextView = findViewById(R.id.userAge)
            val userBloodGroup: TextView = findViewById(R.id.userBloodGroup)

            Picasso.get().load(user.image).into(userImage)
            userName.text = "${user.firstName} ${user.lastName}"
            userAge.text = "Age: ${user.age}"
            userBloodGroup.text = "Blood Group: ${user.bloodGroup}"
        } else {
            // Eğer intent'ten user verisi alınamazsa geri gidilir veya hata mesajı gösterilebilir.
            finish()
        }
    }
}