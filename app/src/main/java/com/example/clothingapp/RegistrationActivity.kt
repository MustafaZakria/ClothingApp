package com.example.clothingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)
        val registerLogin = findViewById<Button>(R.id.register_login)
        registerLogin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        val registerRegister = findViewById<Button>(R.id.register_register)
        registerRegister.setOnClickListener {
            //Todo: check validation of user name and password
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}