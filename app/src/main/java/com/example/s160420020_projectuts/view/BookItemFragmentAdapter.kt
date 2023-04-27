package com.example.s160420020_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.s160420020_projectuts.R
import com.example.s160420020_projectuts.model.Book
import com.example.s160420020_projectuts.util.loadImage


class BookItemFragmentAdapter(val bookList: ArrayList<Book>):
    RecyclerView.Adapter<BookItemFragmentAdapter.BookViewHolder>() {

    class BookViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_book_item, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val id = holder.view.findViewById<TextView>(R.id.txtId)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        holder.view.findViewById<TextView>(R.id.txtId).text = bookList[position].id
        holder.view.findViewById<TextView>(R.id.txtName).text = bookList[position].judul

        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            val action = LibraryBookListFragmentDirections.actionDetail(bookList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progress = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(bookList[position].photoUrl, progress)
    }

    fun updateBookList(newBookList:ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

}