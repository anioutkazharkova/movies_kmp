package com.example.myapplication.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.shared.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.shared.data.MovieItem
import com.example.myapplication.shared.presentation.IMoviesListView
import com.example.myapplication.shared.presentation.IMoviesPresenter
import com.example.myapplication.shared.presentation.MoviesPresenter

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), IMoviesListView {
    val presenter: IMoviesPresenter = MoviesPresenter()
    private var adapter = MoviesAdapter()
    private var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<RecyclerView>(R.id.list)
        list?.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.loadMovies()
    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
    }

    override fun setupItems(items: List<MovieItem>) {
       list?.adapter = adapter
        this.adapter.updateItems(items)
    }
}
