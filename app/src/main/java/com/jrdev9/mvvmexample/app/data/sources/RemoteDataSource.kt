package com.jrdev9.mvvmexample.app.data.sources

import com.jrdev9.mvvmexample.modules.showPokemonList.domain.PokemonModel

interface RemoteDataSource {

    suspend fun getPokemonList(): List<PokemonModel>
}