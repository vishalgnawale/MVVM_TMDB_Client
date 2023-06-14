package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository:MovieRepository {

    val movieList= mutableListOf<Movie>()
    init {
        movieList.add(Movie(1,"Title1","Overview1","Poster Path 1","Second Title 1"))
        movieList.add(Movie(2,"Title2","Overview2","Poster Path 2","Second Title 2"))

    }
    override suspend fun getMovies(): List<Movie> {
        return movieList
    }

    override suspend fun updatedMovies(): List<Movie> {
        movieList.clear()
        movieList.add(Movie(5,"Title5","Overview5","Poster Path 5","Second Title 5"))
        movieList.add(Movie(6,"Title6","Overview6","Poster Path 6","Second Title 6"))
        return movieList
    }
}