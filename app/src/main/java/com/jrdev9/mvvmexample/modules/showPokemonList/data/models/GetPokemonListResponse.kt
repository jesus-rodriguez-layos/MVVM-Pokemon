package com.jrdev9.mvvmexample.modules.showPokemonList.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetPokemonListResponse(
        @SerializedName("count") val totalItems: Int,
        @SerializedName("next") val nextToLoad: String,
        @SerializedName("previous") val previousToLoad: String,
        @SerializedName("results") val pokemonList: List<PokemonResponse>
) : Parcelable