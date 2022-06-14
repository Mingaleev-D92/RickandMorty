package com.example.rickandmorty.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, CharacterActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this, EpisodeActivity::class.java))
        }
    }
}