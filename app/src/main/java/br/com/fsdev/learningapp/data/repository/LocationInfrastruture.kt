package br.com.fsdev.learningapp.data.repository

import br.com.fsdev.learningapp.data.mappers.LocationMapper
import br.com.fsdev.learningapp.data.network.GatewayBuilder
import br.com.fsdev.learningapp.domain.LocationService
import br.com.fsdev.learningapp.domain.models.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationInfrastruture : LocationService {

    private val api = GatewayBuilder.build<RickAndMortyGateway>()

    override suspend fun getLocations(): List<Location> =
        withContext(Dispatchers.IO) {
            api
                .getLocations()
                .results
                .map(LocationMapper::toDomain)
        }

    override suspend fun getLocation(id: Int): Location =
        withContext(Dispatchers.IO) {
            api
                .getLocation(id)
                .let(LocationMapper::toDomain)
        }
}