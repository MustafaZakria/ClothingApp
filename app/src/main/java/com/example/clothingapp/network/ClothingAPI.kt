package com.example.clothingapp.network
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

//https://clothing-store-api-1.herokuapp.com/api/product/v1/all

private const val BASE_URL = "https://clothing-store-api-1.herokuapp.com"
public const val token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFsaWRtYW1kb3VAZ21haWwuY29tIiwiZXhwIjoxNjYwNzA2OTc0LCJpYXQiOjE2NjA2NzA5NzR9.726CFczSD1xkQUc_oZunN_vAwY3JJRexRWnp1AI387o"
public const val email = "khalidmamdou@gmail.com"

interface ClothingAPI {
    @GET("product/v1/all")
    fun getAllProducts(@Header("Authorization")  basicToken:String): Call<List<Product>>

    @GET("api/profile?")
    fun getProfile(@Header("Authorization")  basicToken: String, @Query("email") email: String): Call<User>

    @GET("product/v1/product?")
    fun getProduct(@Header("Authorization")  basicToken: String, @Query("id") id: Int): Call<Product>
}


var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ClothingAPI::class.java)