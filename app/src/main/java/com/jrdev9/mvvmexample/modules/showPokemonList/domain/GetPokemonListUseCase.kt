package com.jrdev9.mvvmexample.modules.showPokemonList.domain

import com.jrdev9.mvvmexample.modules.showPokemonList.data.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val repository: PokemonRepository) {

    suspend fun invoke(): List<PokemonModel> = repository.getPokemonList()
}