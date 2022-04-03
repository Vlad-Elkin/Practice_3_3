package com.example.practice_3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView =findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val spinner:Spinner = findViewById(R.id.spinner)
        val personList = fillList()
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position){
                    0 -> recyclerView.adapter = PersonAdapter(personList)
                    1 -> recyclerView.adapter = PersonAdapter(personList.sortedBy { it.sex })
                    2 -> recyclerView.adapter = PersonAdapter(personList.sortedBy { it.name })
                    3 -> recyclerView.adapter = PersonAdapter(personList.sortedBy { it.phoneNumber })
                }
            }
        }
        recyclerView.adapter = PersonAdapter(personList)
    }
    private fun fillList():List<Person>{
        val data = mutableListOf<Person>()
        resources.openRawResource(R.raw.persons).bufferedReader()
            .forEachLine {
                val line = it.trim()
                if (line.startsWith("{\"")) data.add(Person(JSONObject(line)))
            }
        return data
    }
}