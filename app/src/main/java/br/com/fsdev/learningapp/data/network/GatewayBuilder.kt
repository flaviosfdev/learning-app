package br.com.fsdev.learningapp.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object GatewayBuilder {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    private val contentType: MediaType = MediaType.get("application/json")
    private val json = Json { ignoreUnknownKeys = true }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    inline fun <reified T> build(): T =
        retrofit.create(T::class.java)

}