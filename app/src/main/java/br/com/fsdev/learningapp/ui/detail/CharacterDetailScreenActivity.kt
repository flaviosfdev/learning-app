package br.com.fsdev.learningapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.databinding.ActivityCharacterDetailScreenBinding
import br.com.fsdev.learningapp.domain.models.Character
import kotlinx.coroutines.launch

class CharacterDetailScreenActivity : AppCompatActivity() {

    private val service by lazy { CharacterInfrastructure() }

    private val binding by lazy {
        ActivityCharacterDetailScreenBinding.inflate(layoutInflater)
    }
    private val characterId by lazy { intent?.extras?.getInt(CHARACTER_ID) }

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
        characterId?.let {
            var item: Character? = null
            lifecycleScope.launch {
                service.getCharacter(it).also { item = it }
                item?.let { item ->
                    with(binding) {
                        characterDetailName.text = item.name
                        characterDetailStatus.text = item.status.name
                        characterDetailSpecies.text = item.species
                    }
                }
            }
        }
    }

    companion object {
        const val CHARACTER_ID = "character_id"
    }
}