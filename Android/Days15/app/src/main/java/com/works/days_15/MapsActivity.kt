package com.works.days_15

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.works.days_15.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val galata = LatLng(41.0260178,28.976274)
        mMap.addMarker(MarkerOptions().position(galata).title("Galata Kulesi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galata, 15f))

        val karakoy = LatLng(41.0258559,28.9723472)
        mMap.addMarker(MarkerOptions().position(karakoy).title("Karaköy"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(karakoy))


        // marker pin click
        mMap.setOnInfoWindowClickListener {
            if (it.id == "m0") {
                val url = "https://maps.app.goo.gl/UCSoqM3tVuGQHrZx5"
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(i)
            }else if (it.id == "m1") {
                val gsm = "sms:5455556677"
                val i = Intent(Intent.ACTION_SENDTO, Uri.parse(gsm))
                i.putExtra("sms_body", "Karaköy iskelesinde buluşalım.")
                startActivity(i)
            }
        }


    }
}