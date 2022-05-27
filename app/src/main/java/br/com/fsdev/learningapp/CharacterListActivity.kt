package br.com.fsdev.learningapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.fsdev.learningapp.CharacterDetailScreenActivity.Companion.CHARACTER
import br.com.fsdev.learningapp.databinding.ActivityCharacterListBinding

class CharacterListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCharacterListBinding.inflate(layoutInflater) }
    private val listAdapter by lazy {
        ListAdapter().apply {
            onClick = ::onItemSelected
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
        setupData()
    }

    private fun setup() {
        binding.apply {
            charactersRv.addItemDecoration(
                DividerItemDecoration(
                    this@CharacterListActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            charactersRv.adapter = listAdapter
        }
    }

    private fun onItemSelected(item: Character) {
        val intent = Intent(
            this,
            CharacterDetailScreenActivity::class.java
        )
            .apply {
                putExtra(CHARACTER, item)
            }
        startActivity(intent)
    }

    private fun setupData() {
        listAdapter.addItems(DB.getCharacters())
    }
}