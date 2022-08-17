package com.example.clothingapp.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.login.LoginViewModel
import com.example.clothingapp.ui.activities.registeration.RegistrationActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel : LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerBtn = findViewById<Button>(R.id.btn_login_register)
        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        val loginBtn = findViewById<Button>(R.id.btn_login_login)
        loginBtn.setOnClickListener {
            val password = findViewById<EditText>(R.id.et_password_login).text.toString()
            val email = findViewById<EditText>(R.id.et_email_login).text.toString()
            loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
            loginViewModel.login(email,password)
            loginViewModel.isLoginSuccessful.observe(this, Observer {
                if (it) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, NavigationActivity::class.java))
                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}