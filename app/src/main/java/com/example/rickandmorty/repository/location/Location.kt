package com.example.rickandmorty.repository.location

import com.squareup.moshi.Json

/**
 * @author Mingaleev D. 14.06.2022
 **/
data class Location(
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "dimension")
    val dimension: String
)

data class LocationResponse(
    @Json(name = "results")
    val result: List<Location?>?
)