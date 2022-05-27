package br.com.fsdev.learningapp

class DB {

    companion object {

        fun getCharacters(): List<Character> {
            return List<Character>(20) {
                Character(
                    id = "",
                    name = "Rick",
                    status = "Alive",
                )
            }
        }


        fun getLocations() {}

        fun getEpisodes() {}

    }

}