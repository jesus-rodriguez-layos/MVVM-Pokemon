package com.jrdev9.mvvmexample.app.data.api

import com.jrdev9.mvvmexample.modules.showPokemonList.data.models.GetPokemonListResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    fun getPokemonListAsync(
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
    ): Deferred<Response<GetPokemonListResponse>>
}