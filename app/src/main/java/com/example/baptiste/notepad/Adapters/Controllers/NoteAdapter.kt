package com.example.baptiste.notepad.Adapters.Controllers

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baptiste.notepad.Controllers.Note
import com.example.baptiste.notepad.R
import android.widget.TextView

/**
 * Created by Baptiste on 27/04/2018.
 */
class NoteAdapter(val notes: List<Note>, val itemClickListener: View.OnClickListener): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val cardView = itemView.findViewById(R.id.card_view) as CardView
        val titleView = cardView.findViewById(R.id.title) as TextView
        val excerptView = cardView.findViewById(R.id.excerpt) as TextView

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val viewItem = LayoutInflater.from(parent.context)
                .inflate(R.layout
                        .item_note, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.titleView.text = note.title
        holder.excerptView.text = note.text
    }

    override fun getItemCount(): Int {
        return  notes.size
    }


}