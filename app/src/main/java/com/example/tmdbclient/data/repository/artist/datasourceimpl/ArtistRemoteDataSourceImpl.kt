package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.modal.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):ArtistRemoteDataSource {
    override suspend fun getArtistList(): Response<ArtistList> {
        return tmdbService.getArtistList(apiKey)
    }
}