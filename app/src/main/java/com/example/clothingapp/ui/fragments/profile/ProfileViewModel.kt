package com.example.clothingapp.ui.fragments.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.User
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel: ViewModel() {

    val user = MutableLiveData<User>()

    fun getProfile(loginResponseModel: LoginResponseModel) {

        var email = loginResponseModel.email
        var token = loginResponseModel.token

        retrofit.getProfile(token, email).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                    user.postValue(response.body())
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("***", "onFailure ${t.localizedMessage} ")
            }
        })
    }


}