package com.aiden.knowyoumusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.aiden.knowyoumusic.databinding.GenreItemViewBinding

class GenreAdapter(
    private val genreList: List<String>
) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val binding = GenreItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val currentItem = genreList[position]
        return holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return genreList.size
    }


    inner class GenreViewHolder(private val binding: GenreItemViewBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(genre: String) {
            binding.button.text = genre
            binding.button.setOnClickListener {
                val action =  GenreListFragmentDirections.actionGenreListFragmentToSubGenreFragment(genre = binding.button.text.toString())
                it.findNavController().navigate(action)
            }
        }
    }


}