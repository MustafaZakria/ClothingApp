package com.example.clothingapp.ui.activities.productDetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.NavigationActivity

class ProductDetailsActivity(var id: Int) : AppCompatActivity()  {

    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private lateinit var tvProductPrice: TextView
    private lateinit var tvProductName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)
//        val btnBack = findViewById<Button>(R.id.btn_back)
//        btnBack.setOnClickListener {
//            startActivity(Intent(this, NavigationActivity::class.java))
//        }

        //size drop down menu
        val sizes = resources.getStringArray(R.array.clothes_size)
        val arrayAdapter_size = ArrayAdapter(this, R.layout.dropdown_item, sizes)
        val tvAutocomplete_size = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_size)
        tvAutocomplete_size.setAdapter(arrayAdapter_size)

        val colores = resources.getStringArray(R.array.clothes_color)
        val arrayAdapter_color = ArrayAdapter(this, R.layout.dropdown_item, colores)
        val tvAutocomplete_color = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_color)
        tvAutocomplete_color.setAdapter(arrayAdapter_color)

        //productDetailsViewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
//        productDetailsViewModel.product.observe(this, Observer {
//            if(it != null)
//            {
//
//            }
//
//        })
//    }

    }
}