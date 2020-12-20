package com.example.myapplication.shared.presentation

interface IMoviesPresenter {
  fun loadMovies()
  fun attachView(view: IMoviesListView)

  fun detachView()
}