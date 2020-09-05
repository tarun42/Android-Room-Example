package com.example.android_room_example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
                @PrimaryKey(autoGenerate = true)
                val id:String,
                 //@ColumnInfo(name = "colName")
                 val tiltle: String,
                 val note : String
)