package br.com.fsdev.learningapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.domain.CharacterService
import br.com.fsdev.learningapp.domain.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val service: CharacterService
) : ViewModel(){

    suspend fun getCharacter(id: Int): Character  =
        withContext(Dispatchers.Default) {
            delay(2000L) // REMOVE ME
            service.getCharacter(id)
        }


    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    DetailViewModel(
                        service = CharacterInfrastructure()
                    ) as T
            }
    }

}

