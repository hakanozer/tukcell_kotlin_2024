package com.works.days_16

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.CameraView
import com.otaliastudios.cameraview.PictureResult
import com.otaliastudios.cameraview.VideoResult
import com.otaliastudios.cameraview.controls.Facing

class MainActivity : AppCompatActivity() {

    lateinit var camera: CameraView
    lateinit var c_imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        camera = findViewById(R.id.camera)
        c_imageView = findViewById(R.id.c_imageView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        camera.facing = Facing.FRONT
        camera.addCameraListener(object : CameraListener() {
            override fun onPictureTaken(result: PictureResult) {
                Log.d("onPictureTaken", "onPictureTaken: click ")
                val bytes = result.data
                val bmp:Bitmap = BitmapFactory.decodeByteArray(bytes,0, bytes.size)
                Log.d("size", bytes.size.toString())
                c_imageView.setImageBitmap(bmp)
            }

            override fun onVideoTaken(result: VideoResult) {
                Log.d("onVideoTaken", "onVideoTaken: click ")
            }
        })
    }

    override fun onResume() {
        super.onResume()
        camera.open()
    }

    override fun onPause() {
        super.onPause()
        camera.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        camera.destroy()
    }


}