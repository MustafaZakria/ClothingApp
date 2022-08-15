package com.example.clothingapp.products

data class Product(var price: Int,  var name: String, var image: String
                   ,var size:String="", var description: String="", var color: String=""
                   , var id: Int=0, var isAddedToCart: Boolean=true,
                   var boughtItemsCount: Int=0, var category: String="")


