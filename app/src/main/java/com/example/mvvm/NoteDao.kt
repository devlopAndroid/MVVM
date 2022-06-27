package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun Insert(note: Note)

    @Delete
     fun Delete(note: Note)

    @Query("Select * from notes_table ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>
}