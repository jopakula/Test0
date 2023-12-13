package com.example.test0

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: EditText = findViewById(R.id.editTextLogin)
        val email: EditText = findViewById(R.id.editTextEmail)
        val password: EditText = findViewById(R.id.editTextPassword)
        val button: Button = findViewById(R.id.buttonLogIn)
        val linkToEnt: TextView = findViewById(R.id.LinkToEnt)

        linkToEnt.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val l = login.text.toString().trim()
            val e = email.text.toString().trim()
            val p = password.text.toString().trim()

            when{
                l == "" -> Toast.makeText(this, " Write login", Toast.LENGTH_SHORT).show()
                e == "" -> Toast.makeText(this, "Write email", Toast.LENGTH_SHORT).show()
                p == "" -> Toast.makeText(this, "Write password", Toast.LENGTH_SHORT).show()

                else -> {
                    val user = User(l,e,p)

                    val db = DbHelper(this, null)
                    db.addUser(user)
                    Toast.makeText(this, "User $l created", Toast.LENGTH_SHORT).show()

                    login.text.clear()
                    email.text.clear()
                    password.text.clear()

                }
            }
        }
    }
}
