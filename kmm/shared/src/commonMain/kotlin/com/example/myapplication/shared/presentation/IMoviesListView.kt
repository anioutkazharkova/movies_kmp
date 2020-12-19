package com.example.myapplication.shared.presentation

import com.example.myapplication.shared.data.MovieItem

interface IMoviesListView  {
  fun setupItems(items: List<MovieItem>)
}