package com.example.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class Notedatabase : RoomDatabase() {

    abstract fun getnoteDao(): NoteDao

    companion object {

        @Volatile
        private var INSTANCE: Notedatabase? = null

        fun getDabase(context: Context): Notedatabase {
            // if INSTANCE is null, then create the database
            // if the INSTANCE is not null, then return it,
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,
                        Notedatabase::class.java, "notes_database").build()
                }
            }
            return INSTANCE!!

        }
    }
}