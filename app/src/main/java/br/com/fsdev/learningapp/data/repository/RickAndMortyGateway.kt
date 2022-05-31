package br.com.fsdev.learningapp.data.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyGateway {

    @GET("character")
    suspend fun getCharacters() : CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(
          @Path(value = "id") id: Int
    ) : CharacterResponse

}