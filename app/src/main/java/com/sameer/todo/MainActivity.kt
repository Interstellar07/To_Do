package com.sameer.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rcv = findViewById<RecyclerView>(R.id.RCV)
        rcv.layoutManager = LinearLayoutManager(this)
        val data =ArrayList<DataClass>()
        data.add(DataClass("test"))
        data.add(DataClass("test1"))
        data.add(DataClass("test2"))
        data.add(DataClass("test3"))


        val adapter = TodoAdapter(data)
        rcv.adapter =adapter

        val addtask = findViewById<Button>(R.id.addtask)
        val input = findViewById<EditText>(R.id.editext)
        addtask.setOnClickListener {
            val text = input.text.toString()
            data.add(DataClass(text))
            adapter.notifyDataSetChanged()
        }
    }
}