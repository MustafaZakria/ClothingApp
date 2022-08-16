package com.example.registerusers

import com.example.clothingapp.LoginResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("/api/auth/register")
    fun registerUser(@Body user: User) : Call<RegisterResponseModel>
    @GET("/api/auth/login")
    fun loginUser(@Body username: String, password : String) : Call<LoginResponseModel>
}