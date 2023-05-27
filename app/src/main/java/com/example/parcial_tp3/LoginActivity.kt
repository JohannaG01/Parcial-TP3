package com.example.parcial_tp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val textUserName = findViewById<EditText>(R.id.text_username)
        btnLogin.setOnClickListener(){
            val username = textUserName.text.toString()
            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            intent.putExtra("username", username)
            startActivity(intent)
        }
    }
}