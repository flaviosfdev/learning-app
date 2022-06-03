package br.com.fsdev.learningapp.data.repository.location

import kotlinx.serialization.Serializable

@Serializable
class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)