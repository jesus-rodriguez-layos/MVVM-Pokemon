package com.jrdev9.mvvmexample.modules.showPokemonList.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.PokemonModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResponse(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
) : Parcelable {

    fun buildImageUrl(url: String): String {
        val index = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
                .replace("/", "")
                .toInt()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
    }
}

fun PokemonResponse.toDomainModel(): PokemonModel {
    return PokemonModel(
            name = name,
            url = buildImageUrl(url)
    )
}