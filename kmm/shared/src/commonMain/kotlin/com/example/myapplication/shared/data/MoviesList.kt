package com.example.myapplication.shared.data

import kotlinx.serialization.Serializable


@Serializable
data class MoviesList(var results: List<MovieItem>)