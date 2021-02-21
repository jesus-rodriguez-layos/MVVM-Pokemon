package com.jrdev9.mvvmexample.modules.showPokemonList.domain

import android.annotation.SuppressLint
import com.jrdev9.mvvmexample.modules.showPokemonList.ui.PokemonUiModel

data class PokemonModel(val name: String, val url: String)

@SuppressLint("DefaultLocale")
fun PokemonModel.toUiModel(): PokemonUiModel {
    return PokemonUiModel(
            name = name.capitalize(),
            imageUrl = url
    )
}