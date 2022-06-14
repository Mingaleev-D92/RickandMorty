package com.example.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.rickandmorty.R
import com.example.rickandmorty.repository.character.Result

/**
 * @author Mingaleev D. 11.06.2022
 **/
class CharacterAdapter(val charactersList: List<Result?>?) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(private val itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindData(character: Result?) {
            val name = itemView.findViewById<TextView>(R.id.name_tv)
            val image = itemView.findViewById<ImageView>(R.id.image_character)
            val gender = itemView.findViewById<TextView>(R.id.gender_tv)
            val species = itemView.findViewById<TextView>(R.id.species_tv)
            val location = itemView.findViewById<TextView>(R.id.location_tv)

            name.text = character!!.name
            gender.text = "gender: " + character.gender
            species.text = "species: " + character.species
            location.text = "location: " + character.location!!.name
            image.load(character.image) {
                transformations(CircleCropTransformation())
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindData(charactersList?.get(position))

    }

    override fun getItemCount(): Int {
        return charactersList!!.size

    }
}