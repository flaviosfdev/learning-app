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

        binding.homeCharacterButton.setOnClickListener {
            startActivity(Intent(this, CharacterDetailScreenActivity::class.java))
        }

    }
}