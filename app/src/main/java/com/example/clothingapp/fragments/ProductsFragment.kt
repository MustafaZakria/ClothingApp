package com.example.bottombar.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.clothingapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {

    lateinit var searchView: SearchView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_products, container, false)

        searchView = view.findViewById(R.id.sv_products)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                ///if (programmingLanguagesList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    ///listAdapter.filter.filter(query)
                ///} else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    ///Toast.makeText(this@MainActivity, "No Language found..", Toast.LENGTH_LONG) .show()
                ///}
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                ///listAdapter.filter.filter(newText)
                return false
            }
        })

        return view
    }



}