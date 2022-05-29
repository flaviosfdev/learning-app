package br.com.fsdev.learningapp.domain

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val origin: String
): Serializable

enum class CharacterStatus(
    val status: String
) {
    Alive("alive"),
    Dead("dead"),
    Unknown("unknown");

    companion object {

        fun toStatus(status: String) =
            values().first() { it.status.equals(status, ignoreCase = true) }
    }
}