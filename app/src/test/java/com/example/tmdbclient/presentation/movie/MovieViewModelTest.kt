package com.example.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedMovieUseCase
import com.example.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var insstantTaskExecutor=InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel


    @Before
    fun setUp() {
        val fakeMovieRepository=FakeMovieRepository()
        val fakeGetMovieUseCase=GetMoviesUseCase(fakeMovieRepository)
        val fakeUpdateMoveUseCase=GetUpdatedMovieUseCase(fakeMovieRepository)
        movieViewModel= MovieViewModel(fakeGetMovieUseCase,fakeUpdateMoveUseCase)
    }

    @Test
    fun getMovies_returnCurrentMovies(){
        val movieList= mutableListOf<Movie>()
        movieList.add(Movie(1,"Title1","Overview1","Poster Path 1","Second Title 1"))
        movieList.add(Movie(2,"Title2","Overview2","Poster Path 2","Second Title 2"))
        val currentMovieList = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentMovieList).isEqualTo(movieList)
    }

    @Test
    fun updatedMovie_returnCurrentMovies(){
        val updatedList= mutableListOf<Movie>()
        updatedList.add(Movie(5,"Title5","Overview5","Poster Path 5","Second Title 5"))
        updatedList.add(Movie(6,"Title6","Overview6","Poster Path 6","Second Title 6"))

        val currentMovieList = movieViewModel.updatedMovieList().getOrAwaitValue()
        Truth.assertThat(currentMovieList).isEqualTo(updatedList)
    }
}