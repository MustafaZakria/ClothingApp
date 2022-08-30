package com.example.clothingapp.ui.fragments.profile

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel: ViewModel() {

    val user = MutableLiveData<User>()

    val isProfileUpdated = MutableLiveData<Boolean>()

    fun getProfile(token : String, email : String) {

        retrofit.getProfile(token, email).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                user.postValue(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })
    }

    fun updateProfile(token: String, user: UpdateProfileModel) {
        retrofit.updateProfile(token, user).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful) {
                    isProfileUpdated.postValue(true)
                }
                else {
                    isProfileUpdated.postValue(false)
                    Log.d("***", response.body().toString())
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                isProfileUpdated.postValue(false)
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