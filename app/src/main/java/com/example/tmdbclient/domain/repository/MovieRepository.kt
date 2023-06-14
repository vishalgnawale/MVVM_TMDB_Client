package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.modal.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>
    suspend fun updatedMovies():List<Movie>
}