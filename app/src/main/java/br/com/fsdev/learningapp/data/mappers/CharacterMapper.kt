package br.com.fsdev.learningapp.data.mappers

import br.com.fsdev.learningapp.data.repository.CharacterResponse
import br.com.fsdev.learningapp.domain.Character
import br.com.fsdev.learningapp.domain.CharacterStatus

object CharacterMapper {
    fun toDomain(response: CharacterResponse) =
        with(response) {
            Character(
                id = id,
                name = name,
                status = CharacterStatus.toStatus(status),
                species = species,
                origin = origin
            )
        }
}

