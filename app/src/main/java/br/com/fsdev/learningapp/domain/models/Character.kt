package br.com.fsdev.learningapp.domain.models

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String
): Serializable