package com.umutyusufcinar.umut_yusuf_cinar_odev5

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Buton için tıklama olayı metodu
    fun goToDetails(view: View) {
        val intent = Intent(this, DetailsActivity::class.java) // Yeni etkinliğe geçiş yapmak için Intent oluşturun
        startActivity(intent) // Etkinliği başlatın
    }
}
