package com.example.android_room_example.ui

import android.os.AsyncTask
import android.os.Bundle
import android.renderscript.Script
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.android_room_example.R
import com.example.android_room_example.database.Note
import com.example.android_room_example.database.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch
import com.example.android_room_example.ui.toast

class AddNoteFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_save.setOnClickListener {
            val noteTitle = edit_text_title.text.toString().trim()
            val noteNote = edit_text_note.text.toString().trim()
            if(noteTitle.isEmpty())
            {
                edit_text_title.error="title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }
            if(noteNote.isEmpty())
            {
                edit_text_note.error="Note required"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }

            val note = Note(noteTitle,noteNote)
            launch {
                context?.let { it1 -> NoteDatabase(it1).getNoteDao().addNote(note)
                    Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
                    val action=AddNoteFragmentDirections.ActionSaveNote()
                    Navigation.findNavController(it).navigate(action)
                }
            }

//            saveNote(note)


        }
    }
//    private fun saveNote(note : Note)
//    {
//        class SaveNote : AsyncTask<Void ,Void ,Void  >(){
//            override fun doInBackground(vararg params: Void?): Void? {
//                NoteDatabase(activity!!).getNoteDao().addNote(note)
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//                Toast.makeText(activity,"noted sir",Toast.LENGTH_SHORT).show()
//            }
//        }
//        SaveNote().execute()
//    }
}