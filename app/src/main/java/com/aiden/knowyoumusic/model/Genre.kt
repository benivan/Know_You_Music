package com.aiden.knowyoumusic.model


typealias Genre = ArrayList<GenreElement>

data class GenreElement(
    val name: String,
    val supergenre: Boolean,
    val description: String,
    val genrelist: List<Genrelist>
)

data class Genrelist(
    val name: String,
    val year: String,
    val supergenreFirstTag: String,
    val supergenreSecondTag: List<String>? = null,
    val description: String,
    val songlist: List<String>,
    val playlistID: String,
    val playlistLink: String,
    val spotifyPlaylistLink: String
)

