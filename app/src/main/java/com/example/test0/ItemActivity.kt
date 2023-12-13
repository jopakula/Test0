package com.example.test0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.objectItemTitle)
        val text: TextView = findViewById(R.id.objectItemText)
        val button: Button = findViewById(R.id.buttonBack)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")

        button.setOnClickListener {
            val intent = Intent(this, ItemsActivity::class.java)
            startActivity(intent)
        }
    }


}