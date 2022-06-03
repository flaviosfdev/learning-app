package br.com.fsdev.learningapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fsdev.learningapp.databinding.ActivityHomeBinding
import br.com.fsdev.learningapp.ui.list.ListActivity
import br.com.fsdev.learningapp.ui.list.ListActivity.Companion.IS_CHARACTER
import br.com.fsdev.learningapp.ui.list.ListActivity.Companion.IS_NOT_CHARACTER
import br.com.fsdev.learningapp.ui.list.ListActivity.Companion.ITEMS

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        with(binding) {

            setSupportActionBar(homeToolbar)

            homeCharacterButton.setOnClickListener {
                startActivity(
                    Intent(this.root.context, ListActivity::class.java).apply {
                        putExtra(ITEMS, IS_CHARACTER)
                    }
                )
            }
            homeLocationButton.setOnClickListener {
                startActivity(
                    Intent(this.root.context, ListActivity::class.java).apply {
                        putExtra(ITEMS, IS_NOT_CHARACTER)
                    }
                )
            }
        }
    }
}