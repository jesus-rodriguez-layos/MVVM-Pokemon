package com.jrdev9.mvvmexample.modules.showPokemonList.di

import com.jrdev9.mvvmexample.app.data.api.PokemonApi
import com.jrdev9.mvvmexample.app.data.sources.RemoteDataSource
import com.jrdev9.mvvmexample.app.data.sources.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PokemonRepositoryModule {

    @Provides
    fun provideRemoteDataSource(api: PokemonApi): RemoteDataSource = RemoteDataSourceImpl(api)
}