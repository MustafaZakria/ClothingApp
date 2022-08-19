package com.example.clothingapp.ui.activities.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.login.LoginActivity
import com.example.clothingapp.ui.dataclasses.User

class RegistrationActivity : AppCompatActivity() {

    private lateinit var registrationViewModel : RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        val btnRegister = findViewById<Button>(R.id.btn_register_register)

        btnRegister.setOnClickListener {

            val userName = findViewById<EditText>(R.id.et_username_register).text.toString()
            val password = findViewById<EditText>(R.id.et_password_register).text.toString()
            val email = findViewById<EditText>(R.id.et_email_register).text.toString()


            val user = User(userName, email, password)

            registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

            if(registrationViewModel.registerValidation(email, password, this@RegistrationActivity)) {
                registrationViewModel.register(user)
            }

            registrationViewModel.isRegistrationSuccessful.observe(this, Observer {
                if (it) {
                    Toast.makeText(this@RegistrationActivity, "Registration successful", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                else{
                    Toast.makeText(this@RegistrationActivity, "Email already exists", Toast.LENGTH_LONG).show()
                }
            })
        }

    }
}