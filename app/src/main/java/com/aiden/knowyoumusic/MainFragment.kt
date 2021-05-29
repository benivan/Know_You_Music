package com.aiden.knowyoumusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aiden.knowyoumusic.databinding.FragmentGenreBinding
import com.aiden.knowyoumusic.model.GenreElement
import com.aiden.knowyoumusic.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainFragment : Fragment() {
    private var _binding: FragmentGenreBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentGenreBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var  recyclerView: RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = GenreAdapter(getData())
    }

    private fun getData(): List<GenreElement> {
        val jsonFileString = context?.let { getJsonDataFromAsset(it) }
        val listGenreElement = object : TypeToken<List<GenreElement>>() {}.type
        return Gson().fromJson(jsonFileString, listGenreElement)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}