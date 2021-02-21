package com.jrdev9.mvvmexample.modules.showPokemonList.di

import com.jrdev9.mvvmexample.app.data.sources.RemoteDataSource
import com.jrdev9.mvvmexample.modules.showPokemonList.data.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object GetPokemonListUseCaseModule {

    @Provides
    fun providePokemonRepository(remoteDataSource: RemoteDataSource) = PokemonRepository(remoteDataSource)
}