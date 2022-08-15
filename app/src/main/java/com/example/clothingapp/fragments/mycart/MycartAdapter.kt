package com.example.clothingapp.fragments.mycart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clothingapp.R
import com.example.clothingapp.products.Product
import com.example.clothingapp.products.ProductsAdapter

class MycartAdapter (private val products:List<Product>) : RecyclerView.Adapter<MycartAdapter.ViewHolder> (){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val itemName: TextView
        val itemPrice: TextView
        val itemSize: TextView
        val itemDesc: TextView
        val itemColor: TextView
        val itemImage: ImageView

        init {
            itemName = itemView.findViewById(R.id.tv_cart_name)
            itemPrice = itemView.findViewById(R.id.tv_cart_price)
            itemSize = itemView.findViewById(R.id.tv_cart_size)
            itemDesc = itemView.findViewById(R.id.tv_cart_desc)
            itemColor = itemView.findViewById(R.id.tv_cart_color)
            itemImage = itemView.findViewById(R.id.iv_cart)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MycartAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cart_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MycartAdapter.ViewHolder, position: Int) {
        val product = products[position]

        holder.itemName.text = product.name
        holder.itemPrice.text = product.price.toString()
        holder.itemSize.text = product.size
        holder.itemColor.text = product.color
        holder.itemDesc.text = product.description
        Glide.with(holder.itemView).load(product.image).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}