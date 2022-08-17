package com.example.clothingapp.ui.activities.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.RegisterResponseModel
import com.example.clothingapp.ui.dataclasses.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel : ViewModel(){

    val isRegistrationSuccessful = MutableLiveData<Boolean>()

    fun register(user : User){
        retrofit.registerUser(user).enqueue(object : Callback<RegisterResponseModel> {
            override fun onResponse(call: Call<RegisterResponseModel>, response: Response<RegisterResponseModel>) {
                if (response.isSuccessful) {
                    isRegistrationSuccessful.postValue(true)
                }
                else {
                    isRegistrationSuccessful.postValue(false)
               }
            }

            override fun onFailure(call: Call<RegisterResponseModel>, t: Throwable) {
                isRegistrationSuccessful.postValue(false)
            }
        }
        )
    }
}