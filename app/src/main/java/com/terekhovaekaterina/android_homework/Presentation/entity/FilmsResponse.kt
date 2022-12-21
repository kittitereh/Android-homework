package com.terekhovaekaterina.android_homework.Presentation.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmsResponse(
    @SerialName("items")
    val items: List<Item>?,
    @SerialName("total")
    val total: Int?,
    @SerialName("totalPages")
    val totalPages: Int?
)