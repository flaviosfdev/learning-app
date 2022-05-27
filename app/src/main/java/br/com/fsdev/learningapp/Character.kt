package br.com.fsdev.learningapp

import java.io.Serializable

data class Character(
    val id: String? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val origin: String? = null
): Serializable
