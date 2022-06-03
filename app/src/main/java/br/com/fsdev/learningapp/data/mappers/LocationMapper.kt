package br.com.fsdev.learningapp.data.mappers

import br.com.fsdev.learningapp.data.repository.model.LocationDto
import br.com.fsdev.learningapp.domain.models.Location

object LocationMapper {
    fun toDomain(response: LocationDto) =
        with(response) {
            Location(
                id = id,
                name = name,
                type = type,
                dimension = dimension
            )
        }
}