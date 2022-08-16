package com.example.clothingapp.network
import com.example.clothingapp.ui.dataclasses.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

//https://clothing-store-api-1.herokuapp.com/api/product/v1/all

private const val BASE_URL = "https://clothing-store-api-1.herokuapp.com"

interface ClothingAPI {
    @GET("product/v1/all")
    fun getAllProducts(@Header("Authorization")  basicToken:String): Call<List<Product>>
}


var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ClothingAPI::class.java)