package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.repository.movie.datasource.MovieCachedDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCachedDataSource: MovieCachedDataSource
        ):MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCached()
    }

    override suspend fun updatedMovies(): List<Movie> {
        val newMoviesList=getMovieFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.savedMovieDb(newMoviesList)
        movieCachedDataSource.saveMoviesToCached(newMoviesList)
        return newMoviesList
    }

     suspend fun getMovieFromAPI():List<Movie>{
         lateinit var movieList:List<Movie>
         try {
             val response=movieRemoteDataSource.getMovieList()
             val body=response.body()
             if(body!=null){
                 movieList=body.results
             }
         }catch (e:Exception){
             Log.d("MYTAG",e.message.toString())
         }
         return movieList
    }

    suspend fun getMovieDBFromDb():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
           movieList=movieLocalDataSource.getMovies()
        }catch (e:Exception){
            Log.d("MYTAG",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMovieFromAPI()
            movieLocalDataSource.savedMovieDb(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCached():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList=movieCachedDataSource.getMovieFromCached()
        }catch (e:Exception){
            Log.d("MYTAG",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMovieDBFromDb()
            movieCachedDataSource.saveMoviesToCached(movieList)
        }
        return movieList
    }
}