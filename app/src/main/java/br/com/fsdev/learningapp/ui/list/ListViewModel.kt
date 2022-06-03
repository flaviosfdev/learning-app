package br.com.fsdev.learningapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.data.repository.LocationInfrastruture
import br.com.fsdev.learningapp.domain.CharacterService
import br.com.fsdev.learningapp.domain.LocationService
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.models.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ListViewModel(
    private val characterService: CharacterService,
    private val locationService: LocationService
) : ViewModel() {

    suspend fun getCharacters(): List<Character> =
        withContext(Dispatchers.Default) {
            characterService.getCharacters()
        }

    suspend fun getLocations(): List<Location> =
        withContext(Dispatchers.Default) {
            locationService.getLocations()
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    ListViewModel(
                        characterService = CharacterInfrastructure(),
                        locationService = LocationInfrastruture()
                    ) as T
            }
    }
}
