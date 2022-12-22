package com.terekhovaekaterina.android_homework

import androidx.lifecycle.viewModelScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.terekhovaekaterina.android_homework.Presentation.data.network.FilmApi
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmsGenres
import com.terekhovaekaterina.android_homework.Presentation.entity.Film
import org.junit.Test
import com.terekhovaekaterina.android_homework.Presentation.data.network.FilmRepositoryImpl
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.create
import kotlinx.coroutines.CoroutineScope

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun get_films() {
        val FilmApi: FilmApi =
            Retrofit.Builder()
                .baseUrl("https://kinopoiskapiunofficial.tech")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor{chain ->
                            val request = chain.request()
                                .newBuilder()
                                .addHeader("X-API-KEY", "bb7c91e7-9be8-4be2-b6ca-7fc1f8c64121")
                                .build()

                            chain.proceed(request)
                        }
                        .build()
                )
                .addConverterFactory(
                    Json(builderAction = {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }).asConverterFactory(MediaType.parse("application/json")!!)
                )
                .build()
                .create()

        CoroutineScope.launch {
            val films = filmRepository.getFilms(FilmsGenres.ACTION)
            println("hello")
        }
    }
}