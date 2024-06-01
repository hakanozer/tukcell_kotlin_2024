package com.example.odev10.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.odev10.R
import com.example.odev10.extensions.loadGif
import com.example.odev10.models.IntroSlide

class SliderAdapter(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    inner class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.textView_title)
        private val textDescription = view.findViewById<TextView>(R.id.textView_description)
        private val introSlideImage = view.findViewById<ImageView>(R.id.imageView_sliderview)
        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            textDescription.text = introSlide.description
            introSlideImage.loadGif(introSlide.icon)

//            image.setImageResource(introSlide.icon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size

    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(introSlides[position])

    }
}
