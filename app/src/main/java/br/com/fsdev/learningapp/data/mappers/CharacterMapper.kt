package br.com.fsdev.learningapp.data.mappers

import br.com.fsdev.learningapp.data.repository.CharacterDto
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.models.CharacterStatus

object CharacterMapper {
    fun toDomain(response: CharacterDto) =
        with(response) {
            Character(
                id = id,
                name = name,
                status = CharacterStatus.toStatus(status),
                species = species
            )
        }
}

