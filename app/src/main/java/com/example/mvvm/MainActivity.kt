package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IRVonclick {
    private lateinit var myViewmodel: NoteViewmodel
    private lateinit var mtext: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         mtext = findViewById(R.id.input)
         button = findViewById(R.id.button)
        val recycler = findViewById<RecyclerView>(R.id.Recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRvAdapter(this,this)
        recycler.adapter = adapter

        val dao = Notedatabase.getDabase(applicationContext).getnoteDao()
        val repository = Noterepository(dao)
        myViewmodel =
            ViewModelProvider(this,MainViewmodelFactory(repository)).get(NoteViewmodel::class.java)

        myViewmodel.allNote().observe(this) { list ->
            list.let {
                adapter.updateList(it)
            }
        }

        //  wordViewModel.allWords.observe(owner = this) { words ->
        //            // Update the cached copy of the words in the adapter.
        //            words.let { adapter.submitList(it) }
        //        }
        button.setOnClickListener {
            Inserted(it)
        }
    }

    override fun OnItemClick(note: Note) {
        myViewmodel.deleteNote(note)
        Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()
    }
    fun Inserted(view: View) {
        val inputtext = mtext.text.toString()
        myViewmodel.insertNote(Note(inputtext,0))
        Toast.makeText(this,"Inserted",Toast.LENGTH_SHORT).show()
    }
}