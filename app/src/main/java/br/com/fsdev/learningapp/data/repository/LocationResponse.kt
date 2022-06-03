package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.repository.model.LocationDto
import kotlinx.serialization.Serializable

@Serializable
class LocationResponse(
    val results: List<LocationDto>
)