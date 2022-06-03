package br.com.fsdev.learningapp.data.repository.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val results: List<CharacterDto>
)