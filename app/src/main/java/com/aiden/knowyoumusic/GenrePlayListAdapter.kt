package com.aiden.knowyoumusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.knowyoumusic.databinding.SongItemViewBinding

class GenrePlayListAdapter(private val songList: List<String>):
    RecyclerView.Adapter<GenrePlayListAdapter.GenrePlayListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenrePlayListViewHolder {
       val binding = SongItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GenrePlayListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenrePlayListViewHolder, position: Int) {
        val currentItem = songList[position]
        return holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
      return songList.size
    }


    inner  class GenrePlayListViewHolder(private val binding: SongItemViewBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: String) {
            binding.songItem.text = currentItem.replace("<.*?>".toRegex(), "")
        }

    }



}