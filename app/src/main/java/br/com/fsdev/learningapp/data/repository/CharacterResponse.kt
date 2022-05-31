package br.com.fsdev.learningapp.data.repository

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val results: List<CharacterDto>
)