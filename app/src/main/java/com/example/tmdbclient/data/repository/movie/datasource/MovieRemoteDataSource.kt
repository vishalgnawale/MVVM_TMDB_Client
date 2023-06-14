package com.example.tmdbclient.data.repository.movie.datasource

import com.example.tmdbclient.data.modal.movie.MoviesList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovieList():Response<MoviesList>
}