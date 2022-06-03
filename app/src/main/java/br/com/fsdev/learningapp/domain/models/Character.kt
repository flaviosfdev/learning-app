package br.com.fsdev.learningapp.domain.models

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String
)