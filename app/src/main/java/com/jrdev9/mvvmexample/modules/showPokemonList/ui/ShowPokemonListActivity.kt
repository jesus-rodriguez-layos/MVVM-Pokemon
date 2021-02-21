package com.jrdev9.mvvmexample.modules.showPokemonList.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.jrdev9.mvvmexample.databinding.ActivityShowPokemonListBinding
import com.jrdev9.mvvmexample.modules.showPokemonList.ui.ShowPokemonListViewModel.UiModel
import com.jrdev9.mvvmexample.modules.showPokemonList.ui.ShowPokemonListViewModel.UiModel.Loading
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowPokemonListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowPokemonListBinding
    private lateinit var adapter: PokemonListAdapter
    private val viewModel: ShowPokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPokemonListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        initAdapter()
        observeViewModel()
    }

    private fun initAdapter() {
        adapter = PokemonListAdapter(onClickItem = {})
        binding.recyclerPokemonList.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.pokemonList.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: UiModel) {
        when (uiModel) {
            is Loading -> binding.progressBar.visibility = View.VISIBLE
            is UiModel.Content -> {
                binding.progressBar.visibility = View.GONE
                adapter.updateList(uiModel.pokemonList, 0, 180)
            }
        }
    }
}
