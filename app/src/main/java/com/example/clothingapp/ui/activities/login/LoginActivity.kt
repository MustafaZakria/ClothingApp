package com.example.clothingapp.ui.activities.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.network.email
import com.example.clothingapp.network.responseToken
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.activities.NavigationActivity
import com.example.clothingapp.ui.activities.registration.RegistrationActivity
import com.example.clothingapp.ui.dataclasses.UserLoginModel

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegister = findViewById<Button>(R.id.btn_login_register)
        val btnLogin = findViewById<Button>(R.id.btn_login_login)

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        btnLogin.setOnClickListener {

            val etPassword = findViewById<EditText>(R.id.et_password_login).text.toString()
            val etEmail = findViewById<EditText>(R.id.et_email_login).text.toString()

            loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

            loginViewModel.login(UserLoginModel(etEmail,etPassword))

            loginViewModel.userInfo.observe(this, Observer {
                if (it != null) {
                    //Toast.makeText(this, loginViewModel.token, Toast.LENGTH_LONG).show()
                    responseToken =  it.token
                    email = it.email
//                    val email = it.email
//                    val i = Intent(this@LoginActivity, NavigationActivity::class.java)
//                    i.putExtra("email", email)
//                    startActivity(i)

                    startActivity(Intent(this, NavigationActivity()::class.java))
                }
                else{
                    Toast.makeText(this@LoginActivity, "Wrong username or password", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}