package br.com.fsdev.learningapp.data

import br.com.fsdev.learningapp.domain.Character
import br.com.fsdev.learningapp.domain.CharacterStatus

class DB {

    companion object {

        fun getCharacters(): List<Character> {
            return List(size = 10) {
                Character(
                    id = 1,
                    name = "Rick",
                    status = CharacterStatus.toStatus("Dead"),
                    species = "Human",
                    origin = "Earth"
                )
            }
        }


        fun getLocations() {}

        fun getEpisodes() {}

    }

}