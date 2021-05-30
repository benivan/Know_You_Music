package com.aiden.knowyoumusic

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.knowyoumusic.databinding.ItemViewBinding
import com.aiden.knowyoumusic.model.GenreElement
import com.aiden.knowyoumusic.model.Genrelist


class SubGenreAdapter(
    private val listOfSubgenre: List<Genrelist>
) :
    RecyclerView.Adapter<SubGenreAdapter.SubGenreViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubGenreViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SubGenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubGenreViewHolder, position: Int) {
        val currentItem = listOfSubgenre[position]
        return holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
       return listOfSubgenre.size
    }



    inner class SubGenreViewHolder(private val binding: ItemViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: Genrelist) {
            binding.tvHeading.text = currentItem.name.replace("\\<.*?\\>".toRegex(), "" )
        }

    }



}