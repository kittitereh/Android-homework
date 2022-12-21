package com.terekhovaekaterina.android_homework.Presentation.data.network
import com.terekhovaekaterina.android_homework.Presentation.entity.FilmsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface FilmApi {

    @GET("/api/v2.2/films")
    suspend fun getFilms(
        @Query("genres") genres:Int,
        @Query("countries") countries: Int,
        @Query("yearFrom") yearFrom: Int,
        @Query("yearTo") yearTo: Int,
        @Query("ratingFrom") ratingFrom: Int,
        @Query("ratingTo") ratingTo: Int,
    ): FilmsResponse
}