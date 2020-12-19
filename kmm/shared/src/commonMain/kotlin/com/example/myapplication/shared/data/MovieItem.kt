package com.example.myapplication.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieItem(var id: Int = 0,
                     var title: String = "",
                     var overview: String = "",
                     @SerialName("release_date")var releaseData: String = "",
                     @SerialName("poster_path")var posterPath: String = "") {
   fun imagePath():String  = "http://image.tmdb.org/t/p/w300${posterPath}"
}