package com.example.s160420020_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.s160420020_projectuts.R
import com.example.s160420020_projectuts.util.loadImage
import com.example.s160420020_projectuts.viewmodel.LoginDetailViewModel

class ProfileFragment : Fragment() {
    private lateinit var  loginDetailViewModel: LoginDetailViewModel
    var usernameS = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null)
        {
            usernameS = ProfileFragmentArgs.fromBundle(requireArguments()).username
            Toast.makeText(context, "$usernameS", Toast.LENGTH_SHORT).show()
        }
        loginDetailViewModel = ViewModelProvider(this).get(LoginDetailViewModel::class.java)
        loginDetailViewModel.takeLogin(usernameS)

        observeDetailViewModel()
    }

    fun observeDetailViewModel()
    {
        val id = view?.findViewById<TextView>(R.id.txtIdProfile)
        val username = view?.findViewById<TextView>(R.id.txtUsernameProfile)
        val alamat = view?.findViewById<TextView>(R.id.txtAlamatProfile)
        val btnCekBuku = view?.findViewById<Button>(R.id.btnLihatBuku)
        loginDetailViewModel.loginLD.observe(viewLifecycleOwner, Observer {
            id?.text = it.id
            username?.text = it.username
            alamat?.text = it.alamat
        })
        btnCekBuku?.setOnClickListener {
            val action = ProfileFragmentDirections.actionBookListFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}