package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.repository.model.CharacterDto
import br.com.fsdev.learningapp.data.repository.model.LocationDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyGateway {

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path(value = "id") id: Int
    ): CharacterDto

    @GET("location")
    suspend fun getLocations(): LocationResponse

    @GET("location/{id}")
    suspend fun getLocation(
        @Path(value = "id") id: Int
    ): LocationDto
}