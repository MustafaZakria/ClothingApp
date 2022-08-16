package com.example.clothingapp.ui.fragments.mycart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.ui.adapters.MycartAdapter
import com.example.clothingapp.ui.adapters.ProductsAdapter
import com.example.clothingapp.ui.dataclasses.Product
import com.example.clothingapp.ui.fragments.products.ProductsViewModel
import com.example.clothingapp.ui.fragments.profile.ProfileViewModel


class MycartFragment : Fragment() {

    private lateinit var adapter: RecyclerView.Adapter<MycartAdapter.ViewHolder>
    private  lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var productsViewModel : ProductsViewModel
    private lateinit var mycartViewModel : MycartViewModel


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

                layoutManager = LinearLayoutManager(view.context)
                recyclerView.layoutManager = layoutManager

                adapter = MycartAdapter(maycartProducts)
                recyclerView.adapter = adapter
            }

        })

    }


}