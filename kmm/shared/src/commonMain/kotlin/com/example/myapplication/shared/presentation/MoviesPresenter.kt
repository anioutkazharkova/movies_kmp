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

class MoviesPresenter() : IMoviesPresenter  {
    private var items: ArrayList<MovieItem> = arrayListOf()
    private val service: MoviesService = MoviesService()
    val coroutineContext: CoroutineContext = ioDispatcher
    private lateinit var scope: PresenterCoroutineScope

    override fun attachView(view: IMoviesListView){
        scope = PresenterCoroutineScope(coroutineContext)
        this.view = view

    }

    override fun detachView() {
        scope.viewDetached()
        this.view = null
    }

    override  fun loadMovies() {
        scope.launch {
            val list = service.loadMovies()
            if (list?.results != null) {
                items.addAll(list.results)
                withContext(uiDispatcher) {
                    view?.setupItems(items)
                }
            }
        }
    }

    override var view: IMoviesListView? = null


}

class PresenterCoroutineScope (private val context: CoroutineContext) : CoroutineScope {
    private  var onViewDetachJob = Job()
    override val coroutineContext: CoroutineContext
        get() = context + onViewDetachJob

    fun viewDetached() {
        onViewDetachJob.cancel()
    }
}