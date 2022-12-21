package com.terekhovaekaterina.android_homework.Presentation.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.terekhovaekaterina.android_homework.Presentation.data.network.FilmApi
import com.terekhovaekaterina.android_homework.Presentation.data.network.FilmRepositoryImpl
import com.terekhovaekaterina.android_homework.Presentation.domain.FilmRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.create
import java.security.KeyStore.TrustedCertificateEntry

object NetworkProvider {

    private val FilmApi:FilmApi =
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

    private var filmRepository : FilmRepository?= null

    fun getFilmsRepository():FilmRepository =
        filmRepository ?: FilmRepositoryImpl(FilmApi).also {filmRepository = it}
}





