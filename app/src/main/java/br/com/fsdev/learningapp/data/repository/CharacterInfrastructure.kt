package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.mappers.CharacterMapper
import br.com.fsdev.learningapp.data.network.GatewayBuilder
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterInfrastructure : CharacterService {

    private val gateway by lazy {
        GatewayBuilder.build<RickAndMortyGateway>()
    }

    override suspend fun getCharacters(): List<Character> =
        withContext(Dispatchers.IO) {
            gateway
                .getCharacters()
                .results
                .map(CharacterMapper::toDomain)
        }

    override suspend fun getCharacter(id: Int): Character =
        withContext(Dispatchers.IO) {
        gateway
            .getCharacter(id)
            .let(CharacterMapper::toDomain)
        }

}