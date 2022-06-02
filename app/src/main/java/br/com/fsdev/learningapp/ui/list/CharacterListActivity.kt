package br.com.fsdev.learningapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.databinding.ActivityCharacterListBinding
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.ui.detail.CharacterDetailScreenActivity
import br.com.fsdev.learningapp.ui.detail.CharacterDetailScreenActivity.Companion.CHARACTER_ID
import kotlinx.coroutines.launch

class CharacterListActivity : AppCompatActivity() {

    private val service by lazy { CharacterInfrastructure() }
    private val binding by lazy { ActivityCharacterListBinding.inflate(layoutInflater) }
    private val listAdapter by lazy {
        ListAdapter().apply {
            onClick = ::onItemSelected
        }
    }
    private val viewModel by viewModels<ListViewModel>(ListViewModel.Factory::build)

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
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onItemSelected(item: Character) {
        val intent = Intent(this, CharacterDetailScreenActivity::class.java)
        intent.putExtra(CHARACTER_ID, item.id)
        startActivity(intent)
    }

    private fun setupData() {
        lifecycleScope.launch {
            viewModel.getCharacters()
                .let(listAdapter::addItems)
        }
    }
}
