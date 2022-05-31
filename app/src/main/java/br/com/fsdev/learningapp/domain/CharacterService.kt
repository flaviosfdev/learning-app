package br.com.fsdev.learningapp.domain

import br.com.fsdev.learningapp.domain.models.Character

interface CharacterService {

    suspend fun getCharacters(): List<Character>

    suspend fun getCharacter(id: Int): Character

}