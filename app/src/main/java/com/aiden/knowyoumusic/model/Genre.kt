package com.aiden.knowyoumusic.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


typealias Genre = ArrayList<GenreElement>

data class GenreElement(
    val name: String,
    val supergenre: Boolean,
    val description: String,
    val genrelist: List<Genrelist>
)


@Parcelize
data class Genrelist(
    val name: String,
    val year: String,
    @SerializedName("supergenre-first-tag")
    val supergenreFirstTag: String,
    val supergenreSecondTag: List<String>? = null,
    val description: String,
    val songlist: List<String>,
    val playlistID: String,
    @SerializedName("playlist-link")
    val playlistLink: String,
    @SerializedName("spotify-playlist-link")
    val spotifyPlaylistLink: String
): Parcelable

