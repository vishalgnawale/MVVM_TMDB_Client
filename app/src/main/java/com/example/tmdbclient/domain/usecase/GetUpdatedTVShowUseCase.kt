package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.example.tmdbclient.domain.repository.TVShowRepository

class GetUpdatedTVShowUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun updatedTVShows():List<TVShow>?=tvShowRepository.updatedTVShows()
}