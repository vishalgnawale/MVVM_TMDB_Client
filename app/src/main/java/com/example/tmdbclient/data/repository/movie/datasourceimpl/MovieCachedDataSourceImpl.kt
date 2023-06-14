package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCachedDataSource

class MovieCachedDataSourceImpl: MovieCachedDataSource {
    private var movieList=ArrayList<Movie>()
    override suspend fun getMovieFromCached(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCached(movies: List<Movie>) {
        movieList=ArrayList(movies)
    }
}