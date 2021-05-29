package com.aiden.knowyoumusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.knowyoumusic.databinding.GenreItemViewBinding
import com.aiden.knowyoumusic.databinding.ItemViewBinding
import com.aiden.knowyoumusic.model.GenreElement

class GenreAdapter(
    private val genreList: List<GenreElement>
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
        fun bind(genre: GenreElement) {
            binding.button.text = genre.name
        }
    }


}