package com.example.clothingapp.ui.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.network.email
import com.example.clothingapp.network.token
import com.example.clothingapp.ui.adapters.ProductsAdapter
import com.example.clothingapp.ui.dataclasses.LoginResponseModel
import com.example.clothingapp.ui.dataclasses.User
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import com.example.clothingapp.ui.fragments.products.ProductsViewModel


class ProfileFragment() : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var tvFisrtName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFisrtName = view.findViewById(R.id.tv_first_name)
        tvLastName = view.findViewById(R.id.tv_last_name)
        tvEmail = view.findViewById(R.id.tv_email)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        viewModel.getProfile(email, token)

        viewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                val nameList = it.fullName.split(" ")
                tvFisrtName.text = nameList[0]
                tvLastName.text = nameList[1]
                tvEmail.text = email
            }

        })


    }


}