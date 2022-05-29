package br.com.fsdev.learningapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.fsdev.learningapp.ui.CharacterDetailScreenActivity.Companion.CHARACTER
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
    }

    private fun setup() {
        val divider = DividerItemDecoration(
            this, DividerItemDecoration.VERTICAL
        )

        binding.apply {
            charactersRv.addItemDecoration(divider)
            charactersRv.adapter = listAdapter

            setSupportActionBar(characterListToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        setupData()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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