package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedMovieUseCase

class MovieViewModel(
    private val getMovieUsecase:GetMoviesUseCase,
    private val updatedMovieUseCase: GetUpdatedMovieUseCase
    ):ViewModel() {

    fun getMovies()= liveData {
        val movieList=getMovieUsecase.execute()
        emit(movieList)
    }

    fun updatedMovieList()= liveData {
        val movieList=updatedMovieUseCase.getUpdatedMovie()
        emit(movieList)
    }
}