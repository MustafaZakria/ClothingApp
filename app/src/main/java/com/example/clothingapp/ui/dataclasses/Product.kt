package com.example.clothingapp.ui.dataclasses

data class Product(var price: Int,  var name: String, var image: String
                   ,var size:String="", var description: String="", var color: String=""
                   , var id: Int=0, var isAddedToCart: Boolean=true)


