package br.com.fsdev.learningapp.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import br.com.fsdev.learningapp.R
import br.com.fsdev.learningapp.databinding.ActivityDetailScreenBinding
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailScreenBinding.inflate(layoutInflater)
    }
    private val itemId by lazy { intent?.extras?.getInt(ITEM_ID) }
    private val itemIsCharacter by lazy { intent?.extras?.getBoolean(ITEM) }
    private val viewModel by viewModels<DetailViewModel>(DetailViewModel.Factory::build)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
        setupViews()
    }

    private fun setup() {
        setSupportActionBar(binding.detailToolbar)
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
        itemIsCharacter?.let { itemIsCharacter ->
            val itemId = (itemId as Int)
            binding.apply {
                detailThirdFieldLabel.isVisible = itemIsCharacter
                detailThirdField.isVisible = itemIsCharacter
            }
            if (itemIsCharacter) {
                setupCharacterScreen(itemId)
            } else {
                setupLocationScreen(itemId)
            }
        }
    }

    private fun setupLocationScreen(id: Int) {
        lifecycleScope.launch {
            val item = viewModel.getLocation(id)
            with(binding) {
                detailToolbar.title = getString(R.string.location_detail_title)
                detailName.text = item.name
                detailFirstFieldLabel.text = getString(
                    R.string.location_detail_first_field_label
                )

                detailFirstField.text = item.type
                detailSecondFieldLabel.text = getString(
                    R.string.location_detail_second_field_label
                )
                detailSecondField.text = item.dimension
            }
        }
    }

    private fun setupCharacterScreen(id: Int) {
        lifecycleScope.launch {
            val item = viewModel.getCharacter(id)
            with(binding) {
                detailToolbar.title = getString(R.string.character_detail_title)
                detailName.text = item.name
                detailFirstFieldLabel.text = getString(
                    R.string.character_detail_first_field_label
                )
                detailFirstField.text = item.status.name
                detailSecondFieldLabel.text =
                    getString(R.string.character_detail_second_field_label)
                detailSecondField.text = item.species
                detailThirdFieldLabel.text = getString(
                    R.string.character_detail_third_field_label
                )
                detailThirdField.text = "-"
            }
        }
    }

    companion object {
        const val ITEM = "item"
        const val ITEM_ID = "item_id"
    }
}