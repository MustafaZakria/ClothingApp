package com.example.clothingapp.ui.fragments.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel(){

    val allProducts = MutableLiveData<List<Product>>()

    fun getAllProducts() : Boolean{

        val basicToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFsaWRtYW1kb3VAZ21haWwuY29tIiwiZXhwIjoxNjYwNjk3NzA2LCJpYXQiOjE2NjA2NjE3MDZ9.GEwQfZtUQ3RaUDq_Of9q-M1QbxfwSTD8kkEX9AdjlFU"

        retrofit.getAllProducts(basicToken).enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    //Log.d("****", "onResponse ${response.body()}")
                    allProducts.postValue(response.body())
                }
                else {
                    Log.d("***", "onResponse ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })


        //allProducts.postValue()
        return true
    }

}