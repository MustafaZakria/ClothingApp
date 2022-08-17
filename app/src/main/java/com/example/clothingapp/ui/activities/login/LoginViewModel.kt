package com.example.clothingapp.ui.activities.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    //val isLoginSuccessful = MutableLiveData<Boolean>()
    val userInfo = MutableLiveData<LoginResponseModel>()

    fun login(userLoginModel: UserLoginModel) {

        retrofit.loginUser(userLoginModel).enqueue(object : Callback<LoginResponseModel> {

            override fun onResponse(call: Call<LoginResponseModel>, response: Response<LoginResponseModel>) {
                if (response.isSuccessful) {

                    var token = response.body()?.token.toString()
                    var email = response.body()?.email.toString()

                    userInfo.postValue(LoginResponseModel(email, token))

                } else {
                    userInfo.postValue(null)
                }
            }
            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                userInfo.postValue(null)
            }
        })
    }

}