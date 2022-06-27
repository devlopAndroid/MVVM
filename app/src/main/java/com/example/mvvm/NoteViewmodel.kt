package com.example.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewmodel(private val repository : Noterepository) : ViewModel() {

     fun allNote() : LiveData<List<Note>>{
         return repository.allNotes
     }


    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
            repository.Delete(note)
    }

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.Insert(note)
    }
}