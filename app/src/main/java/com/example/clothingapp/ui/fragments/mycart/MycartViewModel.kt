package com.example.clothingapp.ui.fragments.mycart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.dataclasses.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MycartViewModel : ViewModel() {


    fun getMycartProducts(products: List<Product>): List<Product> {
        val mycartProducts = mutableListOf<Product>()

        for(product in products) {
            if(product.isAddedToCart)
                mycartProducts.add(product)
        }

        return mycartProducts
    }
}