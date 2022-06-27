package com.example.mvvm

import androidx.lifecycle.LiveData

class Noterepository(private val noteDao : NoteDao) {

    // Repository need to access dao so thats why we pass instance of Dao in repository
    // TO access the method of Interface NoteDao we have taken
    // private variable noteDao of Interface NoteDao
    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()


    // If want to Insert something
    fun Insert(note:Note){
        // TO insert data in database we can't directly access database
        // We need to call insert function of NoteDao
        noteDao.Insert(note)

    }
     fun Delete(note: Note){
        // TO delete data in database we can't directly access database
        // We need  to call delete function of NoteDao
        noteDao.Delete(note)
    }

}