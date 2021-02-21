package com.jrdev9.mvvmexample.modules.showPokemonList.di

import com.jrdev9.mvvmexample.modules.showPokemonList.data.PokemonRepository
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShowPokemonListViewModelModule {

    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(repository: PokemonRepository) = GetPokemonListUseCase(repository)
}