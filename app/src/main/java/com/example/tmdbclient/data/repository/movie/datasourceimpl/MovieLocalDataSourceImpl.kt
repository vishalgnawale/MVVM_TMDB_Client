package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao:MovieDao): MovieLocalDataSource {
    override suspend fun getMovies(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override suspend fun savedMovieDb(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
      CoroutineScope(Dispatchers.IO).launch {
          movieDao.deleteAllMovies()
      }
    }
}