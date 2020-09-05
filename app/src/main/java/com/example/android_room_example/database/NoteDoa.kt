package com.example.android_room_example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDoa {
    @Insert
    suspend fun addNote(note : Note)

    @Query(value = "SELECT * FROM note ORDER BY id DESC")//table name is entity name
    suspend fun getAllNote() : List<Note>

    @Insert
    suspend fun addMultieNote(vararg note: Note)
}