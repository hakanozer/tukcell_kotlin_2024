package com.example.odev10.activities

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.odev10.R
import com.example.odev10.adapters.SliderAdapter
import com.example.odev10.databinding.ActivityOnboardingMainBinding
import com.example.odev10.models.IntroSlide

class OnboardingMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingMainBinding
    private val sliderAdapter = SliderAdapter(
        listOf(
            IntroSlide(
                "Welcome to Note App",
                "We help you organize every moment and save important notes easily.",
                R.drawable.gif_main
            ),
            IntroSlide(
                "Edit Note",
                "You can edit the note you want to edit by swiping it to the left.",
                R.drawable.gif_edit
            ),
            IntroSlide(
                "Delete Note",
                "You can delete the note you want to delete by swiping it to the right.",
                R.drawable.gif_delete
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnboardingMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introSliderVp.adapter = sliderAdapter
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupIndicators()
        setCurrentIndicator(0)

        binding.btnNext.setOnClickListener {
            if (binding.introSliderVp.currentItem + 1 < sliderAdapter.itemCount) {
                binding.introSliderVp.currentItem += 1
            } else {
                Intent(applicationContext, RegisterActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        binding.textSkipIntro.setOnClickListener {
            Intent(applicationContext, RegisterActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

        binding.introSliderVp.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(sliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this.layoutParams = layoutParams
            }
            binding.indicatorContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.indicatorContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
