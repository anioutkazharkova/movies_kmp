package com.example.myapplication.shared.presentation

import com.example.myapplication.shared.data.MovieItem
import com.example.myapplication.shared.ioDispatcher
import com.example.myapplication.shared.services.movies.MoviesService
import com.example.myapplication.shared.uiDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MoviesPresenter() : BasePresenter<IMoviesListView>(ioDispatcher), IMoviesPresenter {
    private var items: ArrayList<MovieItem> = arrayListOf()
    private val service: MoviesService = MoviesService()

    override fun loadMovies() {
        scope.launch {
            service.loadMovies {
                val list = it
                if (list?.results != null) {
                    items.addAll(list.results)
                    view?.setupItems(items)
                }
            }
        }
    }
}

