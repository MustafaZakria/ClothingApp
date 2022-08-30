package com.example.clothingapp.network
import com.example.clothingapp.ui.dataclasses.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://clothing-store-api-1.herokuapp.com"


interface ClothingAPI {
    @GET("product/v1/all")
    fun getAllProducts(): Call<List<Product>>

    @GET("api/profile?")
    fun getProfile(@Header("Authorization")  basicToken: String, @Query("email") email: String): Call<User>

    @GET("product/v1/product?")
    fun getProduct(@Header("Authorization")  basicToken: String, @Query("id") id: Int): Call<Product>

    @POST("/api/auth/register")
    fun registerUser(@Body user: User) : Call<Void>

    @POST("/api/auth/login")
    fun loginUser(@Body userLoginModel: UserLoginModel) : Call<LoginResponseModel>

    @PUT("/product/v1/addtocart?")
    fun addToCart(@Header("Authorization")  basicToken: String, @Query("id") id: Int): Call<Void>

    @PUT("api/profile")
    fun updateProfile(@Header("Authorization")  basicToken: String, @Body user: UpdateProfileModel): Call<Void>


}


var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ClothingAPI::class.java)