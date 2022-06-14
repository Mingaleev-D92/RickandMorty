package com.example.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.repository.episode.Episode

/**
 * @author Mingaleev D. 14.06.2022
 **/
class EpisodeAdapter(val episodeList: List<Episode>) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    inner class EpisodeViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(_epis: Episode) {
            val epiName = itemView.findViewById<TextView>(R.id.episode_name_tv)
            val epiAirDate = itemView.findViewById<TextView>(R.id.episode_air_date_tv)
            val epiEpisode = itemView.findViewById<TextView>(R.id.episode_episode_tv)
            val epiSeason = itemView.findViewById<TextView>(R.id.episode_season_tv)

            epiName.text = _epis.name
            epiAirDate.text = "air date: " + _epis.air_date

            epiSeason.text = "season: " + _epis.episode.substring(4)
            epiEpisode.text = "episode: " + _epis.episode.substring(1, 3)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bindData(episodeList[position])
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }

}

