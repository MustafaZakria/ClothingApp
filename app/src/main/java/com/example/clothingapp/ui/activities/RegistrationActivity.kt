package com.example.clothingapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.clothingapp.R

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        val registerBtn = findViewById<Button>(R.id.btn_register)
        registerBtn.setOnClickListener {
            //Todo: check validation of user name and password
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}