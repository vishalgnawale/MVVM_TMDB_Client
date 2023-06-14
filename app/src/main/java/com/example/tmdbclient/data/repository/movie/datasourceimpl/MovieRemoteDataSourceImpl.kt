package com.example.tmdbclient.data.repository.movie.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.modal.movie.MoviesList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService:TMDBService,
    private val apiKey:String
    ): MovieRemoteDataSource {
    override suspend fun getMovieList(): Response<MoviesList> {
        return tmdbService.getMovieList(apiKey)
    }
}