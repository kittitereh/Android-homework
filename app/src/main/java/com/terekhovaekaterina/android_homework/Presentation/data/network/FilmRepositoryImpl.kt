package com.terekhovaekaterina.android_homework.Presentation.data.network

import com.terekhovaekaterina.android_homework.Presentation.domain.FilmRepository
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres
// import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres.Companion.getByInt
import com.terekhovaekaterina.android_homework.Presentation.entity.Film

class FilmRepositoryImpl(
    private val filmApi:FilmApi,
): FilmRepository {
    
    override suspend fun getFilms(
        countries: Int,
        genres: FilmsGenres,
        order: String,
        type: String,
        ratingFrom: Int,
        ratingTo: Int,
        yearFrom: Int,
        yearTo: Int,
        page: Int
    ): List<Film> {
        val response = filmApi.getFilms()
        val filmItem = response.items
        return filmItem?.mapNotNull {
            Film(
                name = it.nameRu ?:return@mapNotNull null,
                year = it.year?: return@mapNotNull null,
                posterUrl = it.posterUrl
            )
        }?: emptyList()
    }
    }
}