package com.example.myapplication.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.shared.data.MovieItem

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var items: ArrayList<MovieItem> = arrayListOf()

    fun updateItems(items: List<MovieItem>) {
        this.items = arrayListOf()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context),parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun getItemCount(): Int {
       return items.size
    }

}