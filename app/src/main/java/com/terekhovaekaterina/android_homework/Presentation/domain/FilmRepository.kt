package com.terekhovaekaterina.android_homework.Presentation.domain

import com.terekhovaekaterina.android_homework.Presentation.entity.Film

interface FilmRepository {

    suspend fun getFilms(countries: Int, genres: FilmsGenres,  order: String, type: String,
                         ratingFrom: Int, ratingTo: Int, yearFrom: Int, yearTo: Int, page: Int): List<Film>
}

enum class FilmsGenres(val genres: Int){
    THRILLER(1),
    DRAMA(2),
    CRIME(3),
    MELODRAMA(4),
    DETECTIVE(5),
    FICTION(6),
    ADVENTURE(7),
    BIOGRAPHY(8),
    NOIR(9),
    WESTERN(10),
    ACTION(11),
    FANTASY(12),
    COMEDY(13),
    WAR(14),
    HISTORY(15),
    MUSIC(16),
    HORROR(17),
    CARTOON(18),
    FAMILY(19),
    MUSICAL(20),
    SPORT(21),
    DOCUMENTARY(22),
    SHORT(23),
    ANIME(24),
    NEWS(26),
    CONCERT(27),
    ADULT(28),
    CEREMONY(29),
    REAL_TV(30),
    GAME(31),
    TALK_SHOW(32),
    CHILDREN(33);

    companion object Genre{
        var genres: Int = 1

        fun getByInt(genres: Int) = values().first { it.genres == genres }
    }
}