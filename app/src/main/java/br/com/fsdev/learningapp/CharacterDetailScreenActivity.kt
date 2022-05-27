package br.com.fsdev.learningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fsdev.learningapp.databinding.ActivityCharacterDetailScreenBinding

class CharacterDetailScreenActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCharacterDetailScreenBinding.inflate(
            layoutInflater
        )
    }
    private val character by lazy {
        intent?.extras?.getSerializable(CHARACTER) as Character
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            characterDetailName.text = character.name
            characterDetailStatus.text = character.status
            characterDetailSpecies.text = character.species
            characterDetailOrigin.text = character.origin
        }
    }

    companion object {
        const val CHARACTER = "character"
    }
}