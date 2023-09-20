package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.rickandmorty.Model.dataCharacter
import com.example.rickandmorty.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data =intent.getParcelableExtra<dataCharacter>("DATA")

        Glide.with(this)
            .load(data!!.image)
            .into(binding.imgDetail)

        binding.tvAge.text=data?.age
        binding.tvSpecies.text=data?.species
        binding.tvStatus.text=data?.status
        binding.characterName.text=data?.name
    }
}