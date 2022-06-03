package br.com.fsdev.learningapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.fsdev.learningapp.databinding.ActivityListBinding
import br.com.fsdev.learningapp.domain.models.Character
import br.com.fsdev.learningapp.ui.detail.CharacterDetailScreenActivity
import br.com.fsdev.learningapp.ui.detail.CharacterDetailScreenActivity.Companion.CHARACTER_ID
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<ListViewModel>(ListViewModel.Factory::build)

    // adapter sem groupie
    private val characterListAdapter by lazy {
        CharacterListAdapter().apply {
            onClick = ::onItemSelected
        }
    }

    // adapter groupie
    private val adapter by lazy { GroupAdapter<GroupieViewHolder>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
        setupDataCharacter()
    }

    private fun setup() {
        val divider = DividerItemDecoration(
            this, DividerItemDecoration.VERTICAL
        )

        binding.apply {
            setSupportActionBar(listToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            listRv.addItemDecoration(divider)
            listRv.adapter = adapter
        }
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

    private fun setupList(items: List<Character>) {
        adapter.apply {
            clear()
            addAll(items.map { ListItemEntry(it) })

            setOnItemClickListener { item, _ ->
                val character = (item as ListItemEntry).item
                onItemSelected(character)
            }
        }
    }

    private fun setupDataCharacter() {
        lifecycleScope.launch {
            setupList(viewModel.getCharacters())
        }
    }

    private fun onItemSelected(item: Character) {
        val intent = Intent(this, CharacterDetailScreenActivity::class.java)
        intent.putExtra(CHARACTER_ID, item.id)
        startActivity(intent)
    }


}
