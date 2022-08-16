package com.example.clothingapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.clothingapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerBtn = findViewById<Button>(R.id.btn_register)
        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        val loginBtn = findViewById<Button>(R.id.btn_login)
        loginBtn.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}