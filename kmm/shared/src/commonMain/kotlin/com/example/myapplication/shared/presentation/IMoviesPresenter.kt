package com.example.myapplication.shared.presentation

interface IMoviesPresenter {
  fun loadMovies()
  var view: IMoviesListView?
  fun attachView(view: IMoviesListView)

  fun detachView()
}