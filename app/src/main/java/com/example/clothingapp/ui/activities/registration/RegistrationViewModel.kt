package com.example.clothingapp.ui.activities.registration

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clothingapp.network.retrofit
import com.example.clothingapp.ui.dataclasses.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel : ViewModel(){

    val isRegistrationSuccessful = MutableLiveData<Boolean>()

    fun register(user : User){
        retrofit.registerUser(user).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    isRegistrationSuccessful.postValue(true)
                }
                else {
                    isRegistrationSuccessful.postValue(false)
               }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                isRegistrationSuccessful.postValue(false)
            }
        }
        )
    }

    fun registerValidation(email: String, pass: String, context: Context): Boolean {
        if(emailValidation(email) && passwordValidation(pass))
            return true
        if(!emailValidation(email))
            Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show()
        if(!passwordValidation(email))
            Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show()
        return false
    }

    fun emailValidation(email : String): Boolean {
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
        return EMAIL_REGEX.toRegex().matches(email);

    }

    fun passwordValidation(pass: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        return passwordPattern.toRegex().matches(pass);
    }
}