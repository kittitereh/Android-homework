package com.terekhovaekaterina.android_homework.Presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Film (
    val name: String,
    val year: Int,
    val posterUrl: String?
): Parcelable


