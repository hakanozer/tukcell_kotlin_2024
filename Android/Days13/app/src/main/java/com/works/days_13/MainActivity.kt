package com.works.days_13

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.works.days_13.ui.HomeFragment
import com.works.days_13.ui.LikeFragment
import com.works.days_13.ui.MessageFragment
import com.works.days_13.ui.ProfileFragment

class MainActivity : AppCompatActivity() {

    private var nav_content: FrameLayout? = null
    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {
            R.id.nav_home -> {
                val frament = HomeFragment.newInstance("","")
                addFragment(frament)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nev_like -> {
                val frament = LikeFragment.newInstance("","")
                addFragment(frament)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_message -> {
                val frament = MessageFragment.newInstance("","")
                addFragment(frament)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                val frament = ProfileFragment.newInstance("","")
                addFragment(frament)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nav_content = findViewById(R.id.nav_content)
        val navigation = findViewById<BottomNavigationView>(R.id.nav_navigation)
        navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

        val fragment = HomeFragment.newInstance("","")
        addFragment(fragment)

    }


    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(com.google.android.material.R.anim.design_bottom_sheet_slide_in, com.google.android.material.R.anim.design_bottom_sheet_slide_out )
            .replace(R.id.nav_content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

}