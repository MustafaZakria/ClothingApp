package com.example.clothingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.registerusers.ApiInterface
import com.example.registerusers.RegisterResponseModel
import com.example.registerusers.ServiceBuilder
import com.example.registerusers.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeration)
        var check = false

        val btnRegister = findViewById<Button>(R.id.register_register)
        btnRegister.setOnClickListener {
            val userName = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            val email = findViewById<EditText>(R.id.et_email).text.toString()
            val user = User(userName, email, password)

            val response = ServiceBuilder.buildService(ApiInterface::class.java)
            response.registerUser(user).enqueue(
                object : Callback<RegisterResponseModel> {
                    override fun onResponse(
                        call: Call<RegisterResponseModel>,
                        response: Response<RegisterResponseModel>
                    ) {
                        if (response.isSuccessful) {
                            check = true
                            Toast.makeText(
                                this@RegistrationActivity,
                                "Registration successful",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(this@RegistrationActivity, "Wrong email", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                        Toast.makeText(this@RegistrationActivity, t.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            )
            //Todo: move to the login screen after register
            if (check){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}