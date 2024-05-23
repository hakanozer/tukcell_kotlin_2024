package com.example.yunusemreceylan_odev8.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.yunusemreceylan_odev8.data.model.Product
import com.example.yunusemreceylan_odev8.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as? Product

        product?.let {
            bindProductDetails(it)
        }
    }

    private fun bindProductDetails(product: Product) {
        binding.apply {
            txtName.text = product.title
            txtInstructions.text = product.description
            val details = """
                Price: ${product.price}
                Rating: ${product.rating}
                Stock: ${product.stock}
                Brand: ${product.brand}
                Category: ${product.category}
            """.trimIndent()
            txtDetails.text = details
            Glide.with(root)
                .load(product.thumbnail)
                .into(rImage)
        }
    }
}
