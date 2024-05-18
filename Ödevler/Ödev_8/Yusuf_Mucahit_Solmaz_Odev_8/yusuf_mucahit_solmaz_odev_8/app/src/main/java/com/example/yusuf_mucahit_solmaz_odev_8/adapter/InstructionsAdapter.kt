package com.example.yusuf_mucahit_solmaz_odev_8.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.yusuf_mucahit_solmaz_odev_8.R

class InstructionsAdapter(context: Context, private val instructions: List<String>) : ArrayAdapter<String>(context, 0, instructions) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.instructions_row, parent, false)
        val instruction = getItem(position)
        val instructionItemTextView = view.findViewById<TextView>(R.id.instructionItem)
        instructionItemTextView.text = instruction
        return view
    }
}
