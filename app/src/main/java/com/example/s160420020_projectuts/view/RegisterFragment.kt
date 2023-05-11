package com.example.s160420020_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.s160420020_projectuts.R
import com.example.s160420020_projectuts.viewmodel.LoginViewModel

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = view?.findViewById<EditText>(R.id.txtRegisterUsername)
        val password = view?.findViewById<EditText>(R.id.txtRegisterPassword)
        val ulangPassword = view?.findViewById<EditText>(R.id.txtRegisterUlangPassword)
        val btnRegister = view?.findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            if (password.text.toString() != ulangPassword.text.toString())
            {
                Toast.makeText(context, "Password Tidak Sama", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val action = RegisterFragmentDirections.actionLogin()
                Navigation.findNavController(it).navigate(action)
                Toast.makeText(context, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }

    }

}