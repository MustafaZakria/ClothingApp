package com.example.clothingapp.ui.fragments.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
import com.example.clothingapp.ui.dataclasses.UpdateProfileModel
import com.example.clothingapp.ui.dataclasses.User
import com.example.clothingapp.ui.dataclasses.UserLoginModel
import com.example.clothingapp.ui.fragments.products.ProductsViewModel


class ProfileFragment() : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private lateinit var etFisrtName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnLogout: Button
    private lateinit var btnUpadte: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etFisrtName = view.findViewById(R.id.et_firstname)
        etLastName = view.findViewById(R.id.et_lastname)
        etEmail = view.findViewById(R.id.et_email)
        btnLogout = view.findViewById(R.id.btn_logout)
        btnUpadte = view.findViewById(R.id.btn_update)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        val email = viewModel.getEmail(sharedPreferences)
        val token = viewModel.getToken(sharedPreferences)
        viewModel.getProfile(token, email)

        viewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
                val nameList = it.fullName.split(" ")
                etFisrtName.setText(nameList[0])

                if(nameList.size>1)
                    etLastName.setText(nameList[1])
                etEmail.setText(it.email)
            }

        })

        btnUpadte.setOnClickListener {
            val firstnameUpdate = etFisrtName.text.toString()
            val lastnameUpdate = etLastName.text.toString()
            val emailUpdate = etEmail.text.toString()

            val userUpdate = UpdateProfileModel("$firstnameUpdate $lastnameUpdate", emailUpdate)

            viewModel.updateProfile(token, userUpdate)

            viewModel.isProfileUpdated.observe(viewLifecycleOwner, Observer {
                if(it) {
                    Toast.makeText(view.context, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(view.context, "Updating profile failed", Toast.LENGTH_SHORT).show()
                }
            })
        }


        btnLogout.setOnClickListener {
            startActivity(Intent(this@ProfileFragment.context, LoginActivity::class.java))
        }


    }


}