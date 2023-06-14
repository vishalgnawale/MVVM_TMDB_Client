package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.example.tmdbclient.domain.repository.TVShowRepository

class GetTVShowUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun getTVShow():List<TVShow>?=tvShowRepository.getTVShow()
}