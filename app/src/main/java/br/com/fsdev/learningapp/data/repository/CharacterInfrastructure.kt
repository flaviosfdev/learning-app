package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.mappers.CharacterMapper
import br.com.fsdev.learningapp.data.network.GatewayBuilder
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.CharacterService

class CharacterInfrastructure : CharacterService {

    private val gateway by lazy {
        GatewayBuilder.build<RickAndMortyGateway>()
    }

    override suspend fun getCharacters(): List<Character> =
        gateway
            .getCharacters()
            .results
            .map(CharacterMapper::toDomain)

    override suspend fun getCharacter(id: Int): Character =
        gateway
            .getCharacter(id)
            .let(CharacterMapper::toDomain)

}