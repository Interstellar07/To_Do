package com.sameer.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val list: ArrayList<DataClass>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.taskview, parent, false)

        return TodoAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = list[position]
        holder.textView.text = ItemsViewModel.title

        holder.delete.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()

        }
    }





    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.Todo)
        val delete :Button = itemView.findViewById(R.id.delete)
    }
}