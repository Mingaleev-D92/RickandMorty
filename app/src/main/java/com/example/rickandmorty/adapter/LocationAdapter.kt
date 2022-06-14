package com.example.rickandmorty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.repository.location.Location

/**
 * @author Mingaleev D. 14.06.2022
 **/
class LocationAdapter(val locationList: List<Location>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    inner class LocationViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(location: Location) {
            val locName = itemView.findViewById<TextView>(R.id.location_name_tv)
            val locType = itemView.findViewById<TextView>(R.id.location_type_tv)
            val locDimension = itemView.findViewById<TextView>(R.id.location_dimension_tv)

            locName.text = location.name
            locType.text = "type: " + location.type
            locDimension.text = "dimension: " + location.dimension
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bindData(locationList[position])
    }

    override fun getItemCount(): Int {
        return locationList.size
    }
}