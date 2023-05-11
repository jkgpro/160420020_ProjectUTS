package com.example.s160420020_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s160420020_projectuts.R
import com.example.s160420020_projectuts.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.refreshLogin()


        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.loginsLD.observe(viewLifecycleOwner, Observer {
            val username = view?.findViewById<EditText>(R.id.txtUsername)?.text
            val password = view?.findViewById<EditText>(R.id.txtPassword)?.text

            val btnLogin = view?.findViewById<Button>(R.id.btnLogin)
            btnLogin?.setOnClickListener {
                val action = LoginFragmentDirections.actionProfileFragment(username.toString())
                Navigation.findNavController(it).navigate(action)
            }
            val btnGoRegister = view?.findViewById<Button>(R.id.btnGoRegister)
            btnGoRegister?.setOnClickListener {
                val action = LoginFragmentDirections.actionRegisterFragment()
                Navigation.findNavController(it).navigate(action)
            }
        })
    }
}

