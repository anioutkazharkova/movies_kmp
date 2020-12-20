package com.example.myapplication.shared.services.movies

import com.example.myapplication.shared.data.MoviesList
import com.example.myapplication.shared.ktorScope
import com.example.myapplication.shared.services.network.NetworkService
import com.example.myapplication.shared.uiDispatcher
import io.ktor.client.request.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MoviesService {
    val networkService = NetworkService()
    suspend fun loadMovies(callback:(MoviesList?)->Unit) {
        ktorScope {

            val url =
                    "http://api.themoviedb.org/3/discover/movie?api_key=6c52966d9be717e486a2a0c499867009&page=1&sort_by=popularity.desc"
            val result = networkService.loadData<MoviesList>(url)
            delay(1000)
            withContext(uiDispatcher) {
                callback(result)
            }
        }
    }
}