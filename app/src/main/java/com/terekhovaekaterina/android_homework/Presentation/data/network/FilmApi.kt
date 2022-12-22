package com.terekhovaekaterina.android_homework.Presentation.data.network
import com.terekhovaekaterina.android_homework.Presentation.entity.FilmsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface FilmApi {

    @GET("/api/v2.2/films")
    suspend fun getFilms(
        @Query("countries") countries: Int = 1,
        @Query("genres") genres:Int = 1,
        @Query("order") order: String = "RATING",
        @Query("type") type: String = "ALL",
        @Query("ratingFrom") ratingFrom: Int = 8,
        @Query("ratingTo") ratingTo: Int = 10,
        @Query("yearFrom") yearFrom: Int = 2022,
        @Query("yearTo") yearTo: Int =2022,
        @Query("page") page: Int = 1

    ): Response<FilmsResponse>
}