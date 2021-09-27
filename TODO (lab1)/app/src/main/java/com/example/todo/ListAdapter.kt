package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var items: List<TODOItem>, var context: Context?): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        return ViewHolder(items, view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: TODOItem = items[position]
        holder.title.text = item.title
        holder.category.text = item.category
        holder.status.isChecked = item.status
        holder.id = item.id!!
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(var items: List<TODOItem>, view: View): RecyclerView.ViewHolder(view) {
        var id: Int = -1
        var title: TextView = view.findViewById(R.id.header)
        var category: TextView = view.findViewById(R.id.category)
        var status: CheckBox = view.findViewById(R.id.status)

        init {
            status.setOnClickListener {
                val checked = items.find { i -> i.id == this.id }
                checked?.status = status.isChecked
            }
        }
    }
}