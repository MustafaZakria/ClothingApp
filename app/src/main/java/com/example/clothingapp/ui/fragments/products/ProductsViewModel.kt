package com.example.clothingapp.ui.fragments.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.dataclasses.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel(){

    val allProducts = MutableLiveData<List<Product>>()

    fun getAllProducts(){


        retrofit.getAllProducts().enqueue(object : Callback<List<Product>> {

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                    allProducts.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })

    }

}