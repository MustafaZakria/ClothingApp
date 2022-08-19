package com.example.clothingapp.ui.fragments.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.login.LoginActivity
import com.example.clothingapp.ui.activities.login.sharedPreferences
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
    private lateinit var btnLogout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sharedPreferences = getSharedPreferences("sharedPrefs", AppCompatActivity.MODE_PRIVATE)

        tvFisrtName = view.findViewById(R.id.tv_first_name)
        tvLastName = view.findViewById(R.id.tv_last_name)
        tvEmail = view.findViewById(R.id.tv_email)
        btnLogout = view.findViewById(R.id.btn_logout)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        viewModel.getProfile(viewModel.getEmail(sharedPreferences), viewModel.getToken(sharedPreferences))

        viewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                val nameList = it.fullName.split(" ")
                tvFisrtName.text = nameList[0]

                if(nameList.size>1)
                    tvLastName.text = nameList[1]
                tvEmail.text = it.email
            }

        })

        btnLogout.setOnClickListener {
            startActivity(Intent(this@ProfileFragment.context, LoginActivity::class.java))
        }


    }


}