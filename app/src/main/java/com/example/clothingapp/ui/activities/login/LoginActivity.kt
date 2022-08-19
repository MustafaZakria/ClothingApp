package com.example.clothingapp.ui.activities.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.NavigationActivity
import com.example.clothingapp.ui.activities.registration.RegistrationActivity
import com.example.clothingapp.ui.dataclasses.UserLoginModel

lateinit var sharedPreferences: SharedPreferences

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel : LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegister = findViewById<Button>(R.id.btn_login_register)
        val btnLogin = findViewById<Button>(R.id.btn_login_login)

        sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        btnLogin.setOnClickListener {

            val etPassword = findViewById<EditText>(R.id.et_password_login).text.toString()
            val etEmail = findViewById<EditText>(R.id.et_email_login).text.toString()

            loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

            loginViewModel.login(UserLoginModel(etEmail, etPassword))


            loginViewModel.userInfo.observe(this, Observer {
                if (it != null) {

                    loginViewModel.saveEmail(it.email, sharedPreferences)
                    loginViewModel.saveToken(it.token, sharedPreferences)


                    startActivity(Intent(this, NavigationActivity()::class.java))


                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}