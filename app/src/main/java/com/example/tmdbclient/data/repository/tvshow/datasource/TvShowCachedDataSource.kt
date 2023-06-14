package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.modal.tvshow.TVShow

interface TvShowCachedDataSource {
    suspend fun getCachedTvShows():List<TVShow>
    suspend fun  saveCachedTvShows(tvShows:List<TVShow>)
}