package br.com.fsdev.learningapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fsdev.learningapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()

    }

    private fun setup() {
        with(binding) {
            homeCharacterButton.setOnClickListener {
                startActivity(Intent(this@HomeActivity, CharacterListActivity::class.java))
            }
        }
    }
}