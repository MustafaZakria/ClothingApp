package com.example.clothingapp.ui.fragments.mycart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MycartViewModel : ViewModel() {

    private val mycartProducts:MutableList<Product> = mutableListOf<Product>()

    fun getMycartProducts(products: List<Product>): List<Product> {

        mycartProducts.clear()

        for(product in products) {
            if(product.addedToCart)
                mycartProducts.add(product)
        }

        return mycartProducts
    }

    fun claculateTotal() :Int{
        var total = 0

        for(product in mycartProducts) {
            total+= product.price
        }
        return total
    }

    fun getProductsCount():Int
    {
        return mycartProducts.size
    }
}