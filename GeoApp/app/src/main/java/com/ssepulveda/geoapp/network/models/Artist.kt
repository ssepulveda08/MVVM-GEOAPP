package com.ssepulveda.geoapp.network.models

import com.google.gson.annotations.SerializedName


data class BaseOpartIsts(@SerializedName("topartists") val topartists: Topartists)

data class Topartists(@SerializedName("artist") val artist: List<Artist>?)

data class Artist(
    @SerializedName("name") val name: String,
    @SerializedName("listeners") val listeners: Int,
    @SerializedName("mbid") val mbid: String,
    @SerializedName("url") val url: String,
    @SerializedName("streamable") val streamable: Int,
    @SerializedName("image") val image: List<Image>
)

data class Image(
    @SerializedName("size") val size: String,
    @SerializedName("#text") val img: String
)

