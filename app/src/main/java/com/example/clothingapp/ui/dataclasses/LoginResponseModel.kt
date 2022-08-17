package com.example.clothingapp.ui.dataclasses

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("email")
    val email : String,
    @SerializedName("token")
    val token : String
)