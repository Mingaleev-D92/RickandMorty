package com.example.rickandmorty.repository.episode

import com.squareup.moshi.Json

/**
 * @author Mingaleev D. 14.06.2022
 **/
data class Episode(
    @Json(name = "name")
    val name: String,
    @Json(name = "air_date")
    val air_date: String,
    @Json(name = "episode")
    val episode: String
)

data class EpisodeResponse(
    @Json(name = "results")
    val result: List<Episode?>?
)