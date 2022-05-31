package br.com.fsdev.learningapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.fsdev.learningapp.data.repository.CharacterInfrastructure
import br.com.fsdev.learningapp.databinding.ActivityHomeBinding
import br.com.fsdev.learningapp.domain.CharacterService
import br.com.fsdev.learningapp.ui.list.CharacterListActivity
import kotlinx.coroutines.launch

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
                startActivity(Intent(this.root.context, CharacterListActivity::class.java))
            }
        }
    }
}