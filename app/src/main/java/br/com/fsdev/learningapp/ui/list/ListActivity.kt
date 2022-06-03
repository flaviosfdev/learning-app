package br.com.fsdev.learningapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.fsdev.learningapp.R
import br.com.fsdev.learningapp.databinding.ActivityListBinding
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.domain.models.Location
import br.com.fsdev.learningapp.ui.detail.DetailActivity
import br.com.fsdev.learningapp.ui.detail.DetailActivity.Companion.ITEM
import br.com.fsdev.learningapp.ui.detail.DetailActivity.Companion.ITEM_ID
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<ListViewModel>(ListViewModel.Factory::build)
    private val adapter by lazy { GroupAdapter<GroupieViewHolder>() }
    private val isCharacter by lazy { intent?.extras?.getBoolean(ITEMS) as Boolean }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
        setupData()
    }

    private fun setup() {
        val divider = DividerItemDecoration(
            this, DividerItemDecoration.VERTICAL
        )
        binding.apply {
            listRv.addItemDecoration(divider)
            listRv.adapter = adapter

            if (isCharacter) {
                setupToolbar(getString(R.string.characters))
            } else {
                setupToolbar(getString(R.string.locations))
            }
        }
    }

    private fun setupData() {
        adapter.apply {
            clear()
            isCharacter.let { isCharacter ->
                lifecycleScope.launch {
                    if (isCharacter) {
                        val items = viewModel.getCharacters()
                        addAll(items.map { CharacterEntry(it) })
                        setOnItemClickListener { item, _ ->
                            val character = (item as CharacterEntry).item
                            onItemSelected(character)
                        }
                    } else {
                        val items = viewModel.getLocations()
                        addAll(items.map { LocationEntry(it) })
                        setOnItemClickListener { item, _ ->
                            val location = (item as LocationEntry).item
                            onItemSelected(location)
                        }
                    }
                }

            }
        }
    }

    private fun setupToolbar(title: String) {
        binding.listToolbar.title = title
        setSupportActionBar(binding.listToolbar)
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

    private fun <T> onItemSelected(item: T) {
        val intent = Intent(this, DetailActivity::class.java)
        when (item) {
            is Character -> {
                intent.putExtra(ITEM_ID, item.id)
                intent.putExtra(ITEM, IS_CHARACTER)
            }
            is Location -> {
                intent.putExtra(ITEM_ID, item.id)
                intent.putExtra(ITEM, IS_NOT_CHARACTER)
            }
        }
        startActivity(intent)
    }

    companion object {
        const val ITEMS = "characters"
        const val IS_CHARACTER = true
        const val IS_NOT_CHARACTER = false
    }
}
