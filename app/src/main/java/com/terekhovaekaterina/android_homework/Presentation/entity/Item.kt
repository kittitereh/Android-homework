package com.terekhovaekaterina.android_homework.Presentation.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("countries")
    val countries: List<Country?>?,
    @SerialName("genres")
    val genres: List<Genre?>?,
    @SerialName("imdbId")
    val imdbId: String?,
    @SerialName("kinopoiskId")
    val kinopoiskId: Int?,
    @SerialName("nameOriginal")
    val nameOriginal: String?,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("posterUrl")
    val posterUrl: String?,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerialName("ratingImdb")
    val ratingImdb: Double?,
    @SerialName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerialName("type")
    val type: String?,
    @SerialName("year")
    val year: Int?
)