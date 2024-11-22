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
        data.add(DataClass("Sample Task"))
        data.add(DataClass("Sample Task 2"))
        data.add(DataClass("Sample Task 3"))
        data.add(DataClass("Sample Task 4"))
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