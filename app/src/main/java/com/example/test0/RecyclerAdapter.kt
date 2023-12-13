package com.example.test0

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter( private val id: List<String>, private val title: List<String>, private val text: List<String>, private val prise: List<String>):
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id: TextView = itemView.findViewById(R.id.listItemId)
        val title: TextView = itemView.findViewById(R.id.listItemTitle)
        val text: TextView = itemView.findViewById(R.id.listItemText)
        val prise: TextView = itemView.findViewById(R.id.listItemPrise)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).
                inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return id.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = id[position]
        holder.title.text = title[position]
        holder.text.text = text[position]
        holder.prise.text = prise[position]

        holder.id.setOnClickListener {
            val intent = Intent(it.context, ItemActivity::class.java)

            intent.putExtra("itemTitle", title[position])
            intent.putExtra("itemText", text[position])

            it.context.startActivity(intent)
        }
    }
}