package com.jrdev9.mvvmexample.modules.showPokemonList.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.GetPokemonListUseCase
import com.jrdev9.mvvmexample.modules.showPokemonList.domain.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowPokemonListViewModel @Inject constructor(
        private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonList = MutableLiveData<UiModel>()
    val pokemonList: LiveData<UiModel> = _pokemonList

    init {
        refresh()
    }

    private fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonList.postValue(UiModel.Loading)
            _pokemonList.postValue(
                    UiModel.Content(getPokemonListUseCase.invoke().map { it.toUiModel() })
            )
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val pokemonList: List<PokemonUiModel>) : UiModel()
    }
}