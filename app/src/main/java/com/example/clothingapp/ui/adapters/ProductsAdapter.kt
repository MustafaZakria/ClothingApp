package com.example.clothingapp.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.productDetails.ProductDetailsActivity
import com.example.clothingapp.ui.dataclasses.Product


class ProductsAdapter(private val products:List<Product>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder> () {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView
        val itemPrice: TextView
        val itemImage: ImageView

        init {
            itemName = itemView.findViewById(R.id.tv_product_name)
            itemPrice = itemView.findViewById(R.id.tv_product_price)
            itemImage = itemView.findViewById(R.id.iv_product)

            itemView.setOnClickListener {
                val pos: Int = adapterPosition
                val product = products[pos]

                itemView.context.startActivity(Intent(itemView.context, ProductDetailsActivity(product.id)::class.java))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.itemName.text = product.name
        holder.itemPrice.text = product.price.toString()
        Glide.with(holder.itemView).load(product.image).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return products.size
    }

}