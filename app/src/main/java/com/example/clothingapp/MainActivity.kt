package com.example.clothingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.btn_login)

        loginBtn.setOnClickListener{
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }
}