package com.example.test0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val login: EditText = findViewById(R.id.editTextLoginEntrance)
        val password: EditText = findViewById(R.id.editTextPasswordEntrance)
        val button: Button = findViewById(R.id.buttonSignInEntrance)
        val linkToReg: TextView = findViewById(R.id.linkToReg)

        button.setOnClickListener {
            val l = login.text.toString().trim()
            val p = password.text.toString().trim()

            when{
                l == "" -> Toast.makeText(this, "Write login", Toast.LENGTH_SHORT).show()
                p == "" -> Toast.makeText(this, "Write password", Toast.LENGTH_SHORT).show()

                else -> {
                    val db = DbHelper(this, null)
                    val isAuth = db.getUser(l, p)

                    when (isAuth){
                        true -> {
                            Toast.makeText(this, "User $l authorized", Toast.LENGTH_SHORT).show()
                            login.text.clear()
                            password.text.clear()

                            val intent = Intent(this, ItemsActivity::class.java)
                            startActivity(intent)
                        }
                        false ->
                            Toast.makeText(this, "User $l not being authorized", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}