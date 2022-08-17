package com.example.clothingapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.clothingapp.R
import com.example.clothingapp.network.email
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import com.example.clothingapp.ui.fragments.mycart.MycartFragment
import com.example.clothingapp.ui.fragments.products.ProductsFragment
import com.example.clothingapp.ui.fragments.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity() : AppCompatActivity() {

    //val loginResponseModel: LoginResponseModel = getLogResponseModel()
    val profileFragment = ProfileFragment()
    val productsFragment = ProductsFragment()
    val mycartFragment = MycartFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        replaceFragment(productsFragment)

        val bottomNaviagation = findViewById<BottomNavigationView>(R.id.btm_bar)

        bottomNaviagation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.profile -> replaceFragment(profileFragment)
                R.id.products -> replaceFragment(productsFragment)
                R.id.my_cart -> replaceFragment(mycartFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

    private fun getLogResponseModel(): LoginResponseModel {
        val extras = intent.extras
        lateinit var email:String
        if (extras != null) {
            val email = extras.getString("email")

            //The key argument here must match that used in the other activity
        }
        return LoginResponseModel(email,token)
    }
}