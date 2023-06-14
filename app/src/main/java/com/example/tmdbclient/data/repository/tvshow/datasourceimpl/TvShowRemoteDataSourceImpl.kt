package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.modal.tvshow.TVShowList
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TVShowList> {
        return tmdbService.getTVShowsList(apiKey)
    }
}
