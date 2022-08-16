package com.example.clothingapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.clothingapp.R

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productdetails)
        // get reference to the string array that we just created
        val sizes = resources.getStringArray(R.array.clothes_size)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, sizes)
        // get reference to the autocomplete text view
        val tvAutocomplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        tvAutocomplete.setAdapter(arrayAdapter)
    }
}