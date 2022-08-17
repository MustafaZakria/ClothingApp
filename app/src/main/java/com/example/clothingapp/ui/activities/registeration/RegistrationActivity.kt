package com.example.clothingapp.ui.activities.registeration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.LoginActivity
import com.example.clothingapp.ui.dataclasses.User
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {
    private lateinit var registrationViewModel : RegistrationViewModel
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private fun isValidString(str: String): Boolean{
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }
    private fun isValidData(userName : String, password: String): Boolean{
        if(userName != "" && password !="")   {
            return true
        }
        return false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)

        val btnRegister = findViewById<Button>(R.id.btn_register_register)
        btnRegister.setOnClickListener {

            val userName = findViewById<EditText>(R.id.et_username_register).text.toString()
            val password = findViewById<EditText>(R.id.et_password_register).text.toString()
            val email = findViewById<EditText>(R.id.et_email_register).text.toString()
            if(!isValidString(email)){
                Toast.makeText(this@RegistrationActivity, "please enter a valid email", Toast.LENGTH_LONG).show()
            }
            val user = User(userName, email, password)

            registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
            registrationViewModel.register(user)
            registrationViewModel.isRegistrationSuccessful.observe(this, Observer {
                if (it && isValidString(email) && isValidData(userName,password)) {
                    Toast.makeText(this@RegistrationActivity, "Registration successful", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                else if(isValidString(email)){
                    Toast.makeText(this@RegistrationActivity, "Registration not successful or Email already exists", Toast.LENGTH_LONG).show()
                }
            })
        }
        val btnLogin = findViewById<Button>(R.id.btn_register_login)
        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}