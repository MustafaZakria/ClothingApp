package com.example.clothingapp.ui.activities.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel(){
    val isLoginSuccessful = MutableLiveData<Boolean>()
    fun login(email : String , password: String){
        retrofit.loginUser(email,password).enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(call: Call<LoginResponseModel>, response: Response<LoginResponseModel>) {
                if (response.isSuccessful) {
                    isLoginSuccessful.postValue(true)
                }
                else {
                    isLoginSuccessful.postValue(false)
               }
            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                isLoginSuccessful.postValue(false)
            }
        }
        )
    }
}