package com.example.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
class Note(var text: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
)