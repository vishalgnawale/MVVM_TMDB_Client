package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.modal.artist.ArtistList
import com.example.tmdbclient.data.modal.movie.MoviesList
import com.example.tmdbclient.data.modal.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query(
            "api_key"
        ) apiKey:String
    ):Response<MoviesList>

    @GET("tv/popular")
    suspend fun getTVShowsList(
        @Query(
            "api_key"
        )apiKey: String
    ):Response<TVShowList>

    @GET("person/popular")
    suspend fun getArtistList(
        @Query(
            "api_key"
        )apiKey: String
    ):Response<ArtistList>
}