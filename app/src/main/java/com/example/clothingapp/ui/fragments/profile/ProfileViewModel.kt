package com.example.clothingapp.ui.fragments.profile

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.User
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel: ViewModel() {

    val user = MutableLiveData<User>()



    fun getProfile(email : String, token : String) {

        retrofit.getProfile(token, email).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.d("***", response.body().toString())
                    user.postValue(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })
    }

    fun getEmail(sharedPreferences: SharedPreferences):String {
        return sharedPreferences.getString("email", " ").toString()
    }

    fun getToken(sharedPreferences: SharedPreferences):String {
        var token = "Bearer ${sharedPreferences.getString("token", " ").toString()}"
        return token
    }
}