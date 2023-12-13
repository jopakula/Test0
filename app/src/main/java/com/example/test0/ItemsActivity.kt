package com.example.test0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val recyclerView: RecyclerView = findViewById(R.id.itemsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerAdapter(getIdList(), getTitleList(), getTextList(), getPriseList())
    }

    private fun getIdList(): List<String>{
        return this.resources.getStringArray(R.array.id).toList()
    }

    private fun getTitleList(): List<String>{
        return this.resources.getStringArray(R.array.title).toList()
    }

    private fun getTextList(): List<String>{
        return this.resources.getStringArray(R.array.text).toList()
    }

    private fun getPriseList(): List<String>{
        return this.resources.getStringArray(R.array.prise).toList()
    }
}