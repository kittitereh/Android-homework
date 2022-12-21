package com.terekhovaekaterina.android_homework.Presentation.data.network

import com.terekhovaekaterina.android_homework.Presentation.domain.FilmRepository
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres
// import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres.Companion.getByInt
import com.terekhovaekaterina.android_homework.Presentation.entity.Item

class FilmRepositoryImpl(
    private val filmApi:FilmApi,
): FilmRepository {

    override suspend fun getFilms(genre: FilmsGenres, country: Int): List<Item> {
        val response = filmApi.getFilms(FilmsGenres.genre, country)
    }
}