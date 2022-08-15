package com.example.clothingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottombar.Fragments.MycartFragment
import com.example.bottombar.Fragments.ProductsFragment
import com.example.bottombar.Fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity() {


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
                R.id.add_shopping_cart -> replaceFragment(productsFragment)
                R.id.shopping_cart -> replaceFragment(mycartFragment)
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
}