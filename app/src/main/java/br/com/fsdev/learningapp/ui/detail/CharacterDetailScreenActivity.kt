package br.com.fsdev.learningapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.fsdev.learningapp.data.repository.CharacterService
import br.com.fsdev.learningapp.databinding.ActivityCharacterDetailScreenBinding
import br.com.fsdev.learningapp.domain.Character

class CharacterDetailScreenActivity : AppCompatActivity() {

    private val service by lazy { CharacterService() }

    private val binding by lazy {
        ActivityCharacterDetailScreenBinding.inflate(layoutInflater)
    }
    private val character by lazy { intent?.extras?.getSerializable(CHARACTER) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
        setupViews()
    }

    private fun setup() {
        setSupportActionBar(binding.characterDetailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViews() {
        character?.let {
            val item = it as Character
            with(binding) {
                characterDetailName.text = item.name
                characterDetailStatus.text = item.status.name
                characterDetailSpecies.text = item.species
                characterDetailOrigin.text = item.origin
            }
        }
    }

    companion object {
        const val CHARACTER = "character"
    }
}