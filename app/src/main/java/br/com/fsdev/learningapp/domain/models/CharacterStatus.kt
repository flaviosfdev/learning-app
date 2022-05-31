package br.com.fsdev.learningapp.domain.models

enum class CharacterStatus(
    val status: String
) {
    Alive("alive"),
    Dead("dead"),
    Unknown("unknown");

    companion object {
        fun toStatus(status: String) =
            values().firstOrNull() { it.status.equals(status, ignoreCase = true) } ?: Unknown
    }
}