package br.com.fsdev.learningapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.domain.CharacterService
import br.com.fsdev.learningapp.domain.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ListViewModel(
    private val service: CharacterService
) : ViewModel() {

    suspend fun getCharacters(): List<Character> =
        withContext(Dispatchers.Default) {
            // REMOVE ME
            // REMOVE ME
            // REMOVE ME
            delay(2000L)
            service.getCharacters()
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    ListViewModel(
                        service = CharacterInfrastructure()
                    ) as T
            }
    }
}
