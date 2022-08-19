package com.example.clothingapp.ui.activities.productDetails

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsViewModel: ViewModel() {

    val product = MutableLiveData<Product>()

    val isAddedToCart = MutableLiveData<Boolean>()

    fun getProduct(id: Int, token:String) {

        retrofit.getProduct(token, id).enqueue(object : Callback<Product> {

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                Log.d("***", response.message())
                product.postValue(response.body())
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })
    }

    fun getId(sharedPreferences: SharedPreferences):Int {
        return sharedPreferences.getInt("id", -1)
    }

    fun getToken(sharedPreferences: SharedPreferences):String {
        var token = "Bearer ${sharedPreferences.getString("token", " ").toString()}"
        return token
    }

    fun addProductToCart(id: Int, token:String) {

        retrofit.addToCart(token, id).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.code() == 200)
                    isAddedToCart.postValue(true)
                else
                    false
            }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })
    }
}