package com.example.recyclerviewdynamicchange

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number.view.*

class Adapter(
    private val context : Context,
    private val listItems : List<Int>,
    private val min : Int
) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_number,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return listItems.size - min
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }
    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {
            var position = adapterPosition
            itemView.numberView.text = listItems[position].toString()
        }
    }
}