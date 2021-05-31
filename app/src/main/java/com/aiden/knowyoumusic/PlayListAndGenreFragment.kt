package com.aiden.knowyoumusic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiden.knowyoumusic.databinding.GenreDetailPlaylistBinding

class PlayListAndGenreFragment : Fragment() {


    private var _binding: GenreDetailPlaylistBinding? = null
    val args: PlayListAndGenreFragmentArgs by navArgs()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = GenreDetailPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSongList.layoutManager = LinearLayoutManager(context)
        binding.rvSongList.adapter = GenrePlayListAdapter(args.subGenrePlayList.songlist)
        binding.tvGenreDescription.text = HtmlCompat.fromHtml(args.subGenrePlayList.description,0)
        binding.tvGenreName.text = args.subGenrePlayList.name.replace("<.*?>".toRegex(), "")
        onYoutubeButtonClick()
        onSpotifyButtonClick()

    }

    private fun onSpotifyButtonClick() {
        binding.btnSpotify.setOnClickListener {
            val queryUrl: Uri = Uri.parse(args.subGenrePlayList.spotifyPlaylistLink)
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            requireActivity().startActivity(intent)
        }
    }

    private fun onYoutubeButtonClick() {
        binding.btnYoutube.setOnClickListener {
            val queryUrl: Uri = Uri.parse(args.subGenrePlayList.playlistLink)
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            requireActivity().startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}