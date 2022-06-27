package com.example.mvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class NotesRvAdapter(private val context: Context, private val listener : IRVonclick) : RecyclerView.Adapter<NotesRvAdapter.MViewholder>() {

    private val allNotes = ArrayList<Note>()

    class MViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val Mytext = itemView.findViewById<TextView>(R.id.txt)
        val deletebutton = itemView.findViewById<Button>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewholder {
        val mviewHolder = MViewholder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        mviewHolder.deletebutton.setOnClickListener {
            listener.OnItemClick(allNotes[mviewHolder.adapterPosition])
        }
        return mviewHolder
    }

    override fun onBindViewHolder(holder: MViewholder, position: Int) {
        val currentNote = allNotes[position]
        holder.Mytext.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newlist: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newlist)
        notifyDataSetChanged()
    }
}
interface IRVonclick{
    fun OnItemClick(note: Note)
}