package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.modal.tvshow.TVShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb():List<TVShow>
    suspend fun saveTvshows(tvShows:List<TVShow>)
    suspend fun clearAll()
}