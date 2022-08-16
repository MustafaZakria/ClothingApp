package com.example.clothingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginRegister = findViewById<Button>(R.id.login_register)
        loginRegister.setOnClickListener {
            //Todo: check validation of user name and password
            startActivity(Intent(this,RegisterationActivity::class.java))
        }
        val loginLogin = findViewById<Button>(R.id.login_login)
        loginLogin.setOnClickListener {
            //Todo: check validation of user name and password
            startActivity(Intent(this,NavigationActivity::class.java))
        }
    }
}