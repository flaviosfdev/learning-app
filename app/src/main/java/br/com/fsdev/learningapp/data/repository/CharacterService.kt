package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.mappers.CharacterMapper
import br.com.fsdev.learningapp.data.network.GatewayBuilder
import br.com.fsdev.learningapp.domain.Character

class CharacterService {

    private val gateway by lazy {
        GatewayBuilder.build<CharacterGateway>()
    }

    suspend fun getCharacters(): List<Character> =
        gateway
            .getCharacters()
            .results
            .map(CharacterMapper::toDomain)

    suspend fun getCharacter(id: Int): Character =
        gateway
            .getCharacter(id)
            .let(CharacterMapper::toDomain)

}