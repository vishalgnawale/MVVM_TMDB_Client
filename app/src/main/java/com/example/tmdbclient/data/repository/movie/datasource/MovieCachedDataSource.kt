package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.modal.movie.Movie

interface MovieCachedDataSource {
    suspend fun getMovieFromCached():List<Movie>
    suspend fun saveMoviesToCached(movies:List<Movie>)
}