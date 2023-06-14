package com.example.tmdbclient.data.modal.movie


import com.example.tmdbclient.data.modal.movie.Movie
import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("results")
    val results: List<Movie>
)