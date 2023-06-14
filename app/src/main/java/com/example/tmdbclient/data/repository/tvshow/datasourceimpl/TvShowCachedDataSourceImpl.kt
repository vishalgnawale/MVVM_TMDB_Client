package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCachedDataSource

class TvShowCachedDataSourceImpl() :TvShowCachedDataSource {
    private var tvShowsList=ArrayList<TVShow>()
    override suspend fun getCachedTvShows(): List<TVShow> {
       return tvShowsList
    }

    override suspend fun saveCachedTvShows(tvShows: List<TVShow>) {
        tvShowsList=ArrayList(tvShows)
    }
}