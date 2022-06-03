package br.com.fsdev.learningapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fsdev.learningapp.data.repository.character.CharacterInfrastructure
import br.com.fsdev.learningapp.data.repository.location.LocationInfrastruture
import br.com.fsdev.learningapp.domain.CharacterService
import br.com.fsdev.learningapp.domain.LocationService
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.models.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val characterService: CharacterService,
    private val locationService: LocationService
) : ViewModel() {

    suspend fun getCharacter(id: Int): Character =
        withContext(Dispatchers.Default) {
            characterService.getCharacter(id)
        }

    suspend fun getLocation(id: Int): Location =
        withContext(Dispatchers.Default) {
            locationService.getLocation(id)
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    DetailViewModel(
                        characterService = CharacterInfrastructure(),
                        locationService = LocationInfrastruture()
                    ) as T
            }
    }

}

