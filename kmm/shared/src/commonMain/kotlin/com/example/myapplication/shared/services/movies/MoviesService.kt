package com.example.myapplication.shared.services.movies

import com.example.myapplication.shared.data.MoviesList
import com.example.myapplication.shared.services.network.NetworkService
import io.ktor.client.request.*

class MoviesService {
    val networkService = NetworkService()
    suspend fun loadMovies():MoviesList? {
        val url =
            "http://api.themoviedb.org/3/discover/movie?api_key=6c52966d9be717e486a2a0c499867009&page=1&sort_by=popularity.desc"
        return networkService.loadData<MoviesList>(url)
    }
}