package com.example.s160420020_projectuts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.s160420020_projectuts.R
import com.example.s160420020_projectuts.util.loadImage
import com.example.s160420020_projectuts.viewmodel.BookDetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LibraryBookDetailFragment : Fragment() {
    private lateinit var  bookDetailViewModel: BookDetailViewModel
    private val bookItemFragmentAdapter = BookItemFragmentAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = LibraryBookDetailFragmentArgs.fromBundle(requireArguments()).id
        bookDetailViewModel = ViewModelProvider(this).get(BookDetailViewModel::class.java)
        bookDetailViewModel.take(id)

        observeDetailViewModel()
    }

    fun observeDetailViewModel()
    {
        val judul = view?.findViewById<TextView>(R.id.txtJudul)
        val photoUrl = view?.findViewById<ImageView>(R.id.imgFoto)
        val pb = view?.findViewById<ProgressBar>(R.id.progressBars)
        val rating = view?.findViewById<TextView>(R.id.txtRating)
        val description = view?.findViewById<TextView>(R.id.txtDescription)
        bookDetailViewModel.bookLD.observe(viewLifecycleOwner, Observer {
            judul?.text = it.judul
            photoUrl?.loadImage(it.photoUrl, pb!!)
            rating?.text = it.rating
            description?.text = it.description


            val book = it
            val btnBacaBukuNotif = view?.findViewById<Button>(R.id.btnBacaBukuNotif)
            btnBacaBukuNotif?.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotif(book.judul.toString(),
                            "Buku sedang dibaca", R.drawable.baseline_error_24)
                    }
            }
        })
    }


}