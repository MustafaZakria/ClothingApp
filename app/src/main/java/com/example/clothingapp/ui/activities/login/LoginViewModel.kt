package com.example.clothingapp.ui.activities.login

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    val userInfo = MutableLiveData<LoginResponseModel?>()


    fun login(userLoginModel: UserLoginModel, mContext: Context){

        retrofit.loginUser(userLoginModel).enqueue(object : Callback<LoginResponseModel> {

            override fun onResponse(call: Call<LoginResponseModel>, response: Response<LoginResponseModel>) {
                if (response.isSuccessful) {

                    var token = response.body()?.token.toString()
                    var email = response.body()?.email.toString()

                    userInfo.postValue(LoginResponseModel(email, token))


                } else {
                    //userInfo.postValue(LoginResponseModel("", ""))
                    Toast.makeText(mContext, "Wrong username or password", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                //userInfo.postValue(null)
            }
        })
    }

    fun saveEmail(email: String, sharedpreferences: SharedPreferences) {
        val editor: SharedPreferences.Editor = sharedpreferences.edit()

        editor.putString("email", email)
        editor.commit()
    }

    fun saveToken(token: String, sharedpreferences: SharedPreferences) {
        val editor: SharedPreferences.Editor = sharedpreferences.edit()

        editor.putString("token", token)
        editor.commit()
    }


}