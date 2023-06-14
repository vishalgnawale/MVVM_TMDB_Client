package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    DatabaseModule::class,
    LocalDataModule::class,
    CachedDataModule::class,
    UseCaseModule::class
    ]
) interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TVShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}
