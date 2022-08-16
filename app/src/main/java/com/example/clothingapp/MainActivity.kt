package com.example.clothingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.registerusers.ApiInterface
import com.example.registerusers.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//login activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginRegister = findViewById<Button>(R.id.login_register)
        loginRegister.setOnClickListener {
            //Todo: check validation of user name and password
            startActivity(Intent(this,MainActivity::class.java))
        }
        var check = false

        val btnLogin = findViewById<Button>(R.id.login_login)
        btnLogin.setOnClickListener {
            val userName = findViewById<EditText>(R.id.et_username_login).text.toString()
            val password = findViewById<EditText>(R.id.et_password_login).text.toString()
            //val user = User(userName, userName, password)
            val response = ServiceBuilder.buildService(ApiInterface::class.java)
            response.loginUser(userName,password).enqueue(
                object : Callback<LoginResponseModel> {
                    override fun onResponse(
                        call: Call<LoginResponseModel>,
                        response: Response<LoginResponseModel>
                    ) {
                        if (response.isSuccessful) {
                            check = true
                            Toast.makeText(
                                this@MainActivity,
                                response.message().toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(this@MainActivity, "Wrong email", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            )
            //Todo: move to the login screen after register
            if (check){
                startActivity(Intent(this,NavigationActivity::class.java))
            }
        }
    }
}