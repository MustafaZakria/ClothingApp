package com.example.clothingapp.ui.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.ui.adapters.ProductsAdapter
import com.example.clothingapp.ui.dataclasses.UserLoginModel


class ProductsFragment() : Fragment() {

    private lateinit var searchView: SearchView

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel : ProductsViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_products, container, false)


/*
        //Search view imp
        searchView = view.findViewById(R.id.sv_products)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

        viewModel.getAllProducts()

        viewModel.allProducts.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty())
            {
                recyclerView = view.findViewById(R.id.rv_products)

                recyclerView.layoutManager = GridLayoutManager(context, 2)

                recyclerView.adapter = ProductsAdapter(it)

            }

        })


    }


}