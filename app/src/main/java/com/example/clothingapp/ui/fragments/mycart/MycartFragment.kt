package com.example.clothingapp.ui.fragments.mycart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.ui.adapters.MycartAdapter
import com.example.clothingapp.ui.dataclasses.Product


class MycartFragment : Fragment() {

    private lateinit var adapter: RecyclerView.Adapter<MycartAdapter.ViewHolder>
    private  lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mycart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.rv_mycart)

        layoutManager = LinearLayoutManager(view.context)
        recyclerView.layoutManager = layoutManager

        val products:List<Product>? = null
        adapter = MycartAdapter(products!!)
        recyclerView.adapter = adapter
    }

/*
    private fun getProducts(): List<Product> {
        return listOf(
                Product(200, "WIDE STRIPE T-SHIRT WITH SLOGAN", "https://static.pullandbear.net/2/photos//2022/V/0/2/p/4245/709/300/4245709300_2_1_8.jpg?t=1645613841633","XL","good material","RED"),
                Product(200, "WIDE STRIPE T-SHIRT WITH SLOGAN", "https://static.pullandbear.net/2/photos//2022/V/0/2/p/4245/709/300/4245709300_2_1_8.jpg?t=1645613841633","XL","good material","RED"),
                Product(200, "WIDE STRIPE T-SHIRT WITH SLOGAN", "https://static.pullandbear.net/2/photos//2022/V/0/2/p/4245/709/300/4245709300_2_1_8.jpg?t=1645613841633","XL","good material","RED"),
                Product(200, "WIDE STRIPE T-SHIRT WITH SLOGAN", "https://static.pullandbear.net/2/photos//2022/V/0/2/p/4245/709/300/4245709300_2_1_8.jpg?t=1645613841633","XL","good material","RED"),
                Product(500,"JOGGER BERMUDA SHORTS AND T-SHIRT WITH BANDLE", "https://static.pullandbear.net/2/photos//2022/I/0/2/p/4693/909/710/4693909710_2_1_8.jpg?t=1652087215265","XL","good material","RED")
        )
    }
*/

}