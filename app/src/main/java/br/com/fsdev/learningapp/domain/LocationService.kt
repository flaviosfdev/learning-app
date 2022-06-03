package br.com.fsdev.learningapp.domain

import br.com.fsdev.learningapp.domain.models.Location

interface LocationService {

    suspend fun getLocations() : List<Location>

    suspend fun getLocation(id: Int) : Location

}