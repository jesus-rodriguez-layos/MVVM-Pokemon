package com.jrdev9.mvvmexample.app.data.sources

import com.jrdev9.mvvmexample.app.data.api.PokemonApi
import com.jrdev9.mvvmexample.modules.showPokemonList.data.models.toDomainModel
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.PokemonModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val api: PokemonApi) : RemoteDataSource {

    override suspend fun getPokemonList(): List<PokemonModel> {
        val response = api.getPokemonListAsync(0, 30)
        return with(response.await()) {
            body()!!.pokemonList.map { it.toDomainModel() }
        }
    }
}