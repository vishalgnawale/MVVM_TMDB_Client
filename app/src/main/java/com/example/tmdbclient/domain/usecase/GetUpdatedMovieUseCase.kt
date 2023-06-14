package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class GetUpdatedMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun getUpdatedMovie():List<Movie>?=movieRepository.updatedMovies()
}