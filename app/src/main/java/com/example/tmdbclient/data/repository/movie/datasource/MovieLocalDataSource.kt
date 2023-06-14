package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.modal.movie.MoviesList

interface  MovieLocalDataSource {
    suspend fun getMovies():List<Movie>
    suspend fun savedMovieDb(movies:List<Movie>)
    suspend fun clearAll()
}