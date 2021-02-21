package com.jrdev9.mvvmexample.modules.showPokemonList.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jrdev9.mvvmexample.app.ui.extensions.load
import com.jrdev9.mvvmexample.databinding.ItemPokemonBinding

class PokemonListAdapter(
        private val onClickItem: (PokemonUiModel) -> Unit
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private val pokemonList: MutableList<PokemonUiModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon) { onClickItem(pokemon) }
    }

    override fun getItemCount(): Int = pokemonList.size

    class ViewHolder(private val binding: ItemPokemonBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: PokemonUiModel, onClickItem: () -> Unit) {
            binding.containerPokemon.setOnClickListener { onClickItem() }
            binding.tvNamePokemon.text = pokemon.name
            binding.imgPokemon.load(pokemon.imageUrl)
        }
    }

    fun updateList(data: List<PokemonUiModel>, rangeStart: Int, rangeEnd: Int) {
        pokemonList.addAll(data)
        notifyItemRangeChanged(rangeStart, rangeEnd)
    }
}