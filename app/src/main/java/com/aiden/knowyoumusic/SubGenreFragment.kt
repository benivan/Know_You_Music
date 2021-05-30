package com.aiden.knowyoumusic


import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiden.knowyoumusic.databinding.SubGenreFragmentBinding
import com.aiden.knowyoumusic.model.GenreElement
import com.aiden.knowyoumusic.utils.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SubGenreFragment : Fragment() {

    private var _binding: SubGenreFragmentBinding? = null

    private val binding get() = _binding!!

    lateinit var genreName:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            genreName = it.getString("genre").toString()
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = SubGenreFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSubgenre.layoutManager = LinearLayoutManager(context)
        binding.rvSubgenre.adapter = SubGenreAdapter(getData().genrelist)
        binding.textView2.text = getData().name
        binding.textView4.text = getData().description.replace("\\<.*?\\>".toRegex(), "" )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getData(): GenreElement {
        val jsonFileString = context?.let { getJsonDataFromAsset(it) }
        val genreElement = object : TypeToken<List<GenreElement>>() {}.type
        val subGenreList = Gson().fromJson<List<GenreElement>>(jsonFileString, genreElement)
        return subGenreList.find { it.name == genreName }!!
    }



}