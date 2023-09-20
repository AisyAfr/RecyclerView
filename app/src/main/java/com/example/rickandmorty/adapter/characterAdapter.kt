package com.example.rickandmorty.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.DetailActivity
import com.example.rickandmorty.Model.dataCharacter
import com.example.rickandmorty.databinding.GridItemBinding

class characterAdapter (
    val listCharacter: ArrayList<dataCharacter>
        ): RecyclerView.Adapter<characterAdapter.ListViewHolder>(){
            class ListViewHolder (val binding:GridItemBinding)
                :RecyclerView
    .ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = GridItemBinding
            .inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val character = listCharacter[position]

        Glide.with(holder.itemView.context)
            .load(character.image)
            .into(holder.binding.imgMain)

        holder.binding.tvTitle.text = character.name
        holder.binding.tvSpecies.text = character.species

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("DATA", character)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listCharacter.size

        }

