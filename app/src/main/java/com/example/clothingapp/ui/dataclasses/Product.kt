package com.example.clothingapp.ui.dataclasses

import com.google.gson.annotations.SerializedName

data class Product(var price: Int, var name: String, var image: String
                   , var size:String, var description: String, var color: String
                   , var id: Int, var isAddedToCart: Boolean=true,
                   var boughtItemsCount: Int,var category: String )



