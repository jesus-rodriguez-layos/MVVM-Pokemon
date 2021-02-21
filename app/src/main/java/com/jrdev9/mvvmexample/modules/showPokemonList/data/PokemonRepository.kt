package com.jrdev9.mvvmexample.modules.showPokemonList.data

import com.jrdev9.mvvmexample.app.data.sources.RemoteDataSource
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.PokemonModel
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getPokemonList(): List<PokemonModel> {
        return remoteDataSource.getPokemonList()
    }
}