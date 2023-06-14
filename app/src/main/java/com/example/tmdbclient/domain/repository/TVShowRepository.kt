package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.modal.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShow():List<TVShow>
    suspend fun updatedTVShows():List<TVShow>
}