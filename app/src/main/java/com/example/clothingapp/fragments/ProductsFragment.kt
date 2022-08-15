package com.example.clothingapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.products.Product
import com.example.clothingapp.products.ProductsAdapter



class ProductsFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var adapter: RecyclerView.Adapter<ProductsAdapter.ViewHolder>
    private  lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_products, container, false)



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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.rv_products)

        layoutManager = GridLayoutManager(context, 2)
        recyclerView?.layoutManager = layoutManager

        val products:List<Product> = getProducts()
        adapter = ProductsAdapter(products)
        recyclerView?.adapter = adapter
    }

    private fun getProducts(): List<Product> {
        return listOf(Product(200, "WIDE STRIPE T-SHIRT WITH SLOGAN", "https://static.pullandbear.net/2/photos//2022/V/0/2/p/4245/709/300/4245709300_2_1_8.jpg?t=1645613841633"),
                Product(500,"JOGGER BERMUDA SHORTS AND T-SHIRT PACK", "https://static.pullandbear.net/2/photos//2022/I/0/2/p/4693/909/710/4693909710_2_1_8.jpg?t=1652087215265"))
    }


}