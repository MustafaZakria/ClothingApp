package com.example.clothingapp.ui.activities.productDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clothingapp.R
import com.example.clothingapp.network.email
import com.example.clothingapp.ui.fragments.profile.ProfileViewModel

class ProductDetailsActivity(var id: Int) : AppCompatActivity() {

    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private lateinit var tvProductPrice: TextView
    private lateinit var tvProductName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)

        val sizes = resources.getStringArray(R.array.clothes_size)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, sizes)
        val tvAutocomplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        tvAutocomplete.setAdapter(arrayAdapter)

        productDetailsViewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)

        productDetailsViewModel.getProduct(id)

        productDetailsViewModel.product.observe(this, Observer {
            if(it != null)
            {

            }

        })
    }
}