package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.Model.dataCharacter
import com.example.rickandmorty.databinding.ActivityMainBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.adapter.characterAdapter

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<dataCharacter>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCharacter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvCharacter = binding.rvMain
        rvCharacter.setHasFixedSize(true)

        list.addAll(getListCharacters())

        showRecylcerView()
    }

    private fun showRecylcerView() {
        rvCharacter.layoutManager = LinearLayoutManager(this)

        val listCharacterAdapter = characterAdapter(list)
        rvCharacter.adapter = listCharacterAdapter
    }

    private fun getListCharacters(): ArrayList<dataCharacter> {
        val species = resources.getStringArray(R.array.data_species)
        val age = resources.getStringArray(R.array.data_age)
        val status = resources.getStringArray(R.array.data_status)
        val name = resources.getStringArray(R.array.data_name)
        val image = resources.obtainTypedArray(R.array.data_photo)

        val characters = ArrayList<dataCharacter>()

        for (i in species.indices){
            val character = dataCharacter(
                species [i],
                age[i],
                status[i],
                name[i],
                image.getResourceId(i,-1))
            characters.add(character)
        }

        return characters
    }

}