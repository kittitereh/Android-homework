package com.terekhovaekaterina.android_homework.Presentation.entity


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("countries")
    val countries: Int?,
    @SerialName("genres")
    val genres: Int?,
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