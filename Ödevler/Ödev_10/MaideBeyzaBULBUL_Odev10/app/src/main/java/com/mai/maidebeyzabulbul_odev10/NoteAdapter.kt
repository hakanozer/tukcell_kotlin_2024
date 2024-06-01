package com.mai.maidebeyzabulbul_odev10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NoteAdapter(private val context: Context, private val notes: List<Note>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return notes.size
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return notes[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_note, parent, false)
            viewHolder = ViewHolder()
            viewHolder.titleTextView = view.findViewById(R.id.note_title)
            viewHolder.contentTextView = view.findViewById(R.id.note_content)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val note = notes[position]
        viewHolder.titleTextView?.text = note.title
        viewHolder.contentTextView?.text = note.content

        return view
    }

    private class ViewHolder {
        var titleTextView: TextView? = null
        var contentTextView: TextView? = null
    }
}