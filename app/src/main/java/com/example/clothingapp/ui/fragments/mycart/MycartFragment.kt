package com.example.clothingapp.ui.fragments.mycart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.ui.adapters.MycartAdapter
import com.example.clothingapp.ui.adapters.ProductsAdapter
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import com.example.clothingapp.ui.fragments.products.ProductsViewModel
import com.example.clothingapp.ui.fragments.profile.ProfileViewModel


class MycartFragment() : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var productsViewModel : ProductsViewModel
    private lateinit var mycartViewModel : MycartViewModel

    private lateinit var tvHeader : TextView
    private lateinit var tvFooter : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mycart, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        mycartViewModel = ViewModelProvider(this).get(MycartViewModel::class.java)

        productsViewModel.getAllProducts()

        productsViewModel.allProducts.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty())
            {
                val maycartProducts = mycartViewModel.getMycartProducts(it)
                recyclerView = view.findViewById<RecyclerView>(R.id.rv_mycart)

                recyclerView.layoutManager = LinearLayoutManager(view.context)

                recyclerView.adapter = MycartAdapter(maycartProducts)

                setItemsCount(view)
                setTotal(view)
            }

        })



    }

    fun setTotal(view: View) {
        val total = mycartViewModel.claculateTotal()

        tvFooter = view.findViewById(R.id.tv_total_value)
        tvFooter.text = "EGP $total"
    }

    fun setItemsCount(view: View) {
        val itemsCount = mycartViewModel.getProductsCount()

        tvHeader = view.findViewById(R.id.tv_header)
        tvHeader.text = "My Cart ($itemsCount)"
    }

}