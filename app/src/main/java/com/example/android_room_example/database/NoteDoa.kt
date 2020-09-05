package com.example.android_room_example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDoa {
    @Insert
    fun addNote(note : Note)

    @Query(value = "SELECT * FROM note")//table name is entity name
    fun getAllNote() : List<Note>

    @Insert
    fun addMultieNote(vararg note: Note)
}