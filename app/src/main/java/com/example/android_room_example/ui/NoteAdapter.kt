package com.example.android_room_example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_room_example.R
import com.example.android_room_example.database.Note
import kotlinx.android.synthetic.main.note_layout.view.*

class NoteAdapter(val notes: List<Note>)  : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    class NoteViewHolder(val view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout, parent,false)
        )
    }
    override fun getItemCount() =notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.text_view_title.text=notes[position].title
        holder.view.text_view_note.text=notes[position].note
    }


}