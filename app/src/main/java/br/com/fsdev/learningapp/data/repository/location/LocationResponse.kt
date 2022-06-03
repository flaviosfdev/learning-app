package br.com.fsdev.learningapp.data.repository.location

import kotlinx.serialization.Serializable

@Serializable
class LocationResponse(
    val results: List<LocationDto>
)