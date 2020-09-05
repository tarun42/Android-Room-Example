package com.example.android_room_example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_room_example.R
import com.example.android_room_example.database.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        btn_add.setOnClickListener {
            val action = HomeFragmentDirections.ActionAddNote()
            Navigation.findNavController(it).navigate(action)

        }
        launch {
            context?.let {
                val notes= NoteDatabase(it).getNoteDao().getAllNote()
                recyclerView.adapter = NoteAdapter(notes)
            }
        }


    }
}