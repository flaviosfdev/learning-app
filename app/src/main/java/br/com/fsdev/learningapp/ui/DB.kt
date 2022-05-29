package br.com.fsdev.learningapp.ui

class DB {

    companion object {

        fun getCharacters(): List<Character> {
            return List(size = 20) {
                Character(
                    id = "",
                    name = "Rick",
                    status = "Alive",
                    species = "Human",
                    origin = "Earth"
                )
            }
        }


        fun getLocations() {}

        fun getEpisodes() {}

    }

}