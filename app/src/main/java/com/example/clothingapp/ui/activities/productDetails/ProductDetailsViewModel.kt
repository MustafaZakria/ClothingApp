package com.example.clothingapp.ui.activities.productDetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsViewModel: ViewModel() {

    val product = MutableLiveData<Product>()

    fun getProduct(id: Int) {

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
}