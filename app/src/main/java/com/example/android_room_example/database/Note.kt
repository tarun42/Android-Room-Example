package com.example.android_room_example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (

                 //@ColumnInfo(name = "colName")
                 val title: String,
                 val note : String
)
{
    @PrimaryKey(autoGenerate = true)
 
    var id : Int = 0
}