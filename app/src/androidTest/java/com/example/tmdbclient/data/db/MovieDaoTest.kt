package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.modal.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()
    private lateinit var movieDao: MovieDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase=Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        movieDao=tmdbDatabase.movieDao()
    }
    @Test
     fun saveMoviesTest()= runBlocking {
        var movies= listOf(
            Movie(1,"Title1","Overview1","Poster Path 1","Second Title 1"),
            Movie(2,"Title2","Overview2","Poster Path 2","Second Title 2"),
            Movie(3,"Title3","Overview3","Poster Path 3","Second Title 3"),
            Movie(4,"Title4","Overview4","Poster Path 4","Second Title 4")
        )
        movieDao.saveMovies(movies)
        val allMovies=movieDao.getAllMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)


    }

    @Test
    fun deleteMovies()= runBlocking {
        var movies= listOf(
            Movie(1,"Title1","Overview1","Poster Path 1","Second Title 1"),
            Movie(2,"Title2","Overview2","Poster Path 2","Second Title 2"),
            Movie(3,"Title3","Overview3","Poster Path 3","Second Title 3"),
            Movie(4,"Title4","Overview4","Poster Path 4","Second Title 4")
        )
        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val movieRsult=movieDao.getAllMovies()
        Truth.assertThat(movieRsult).isEmpty()
    }
    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

}