package com.example.rickandmorty.repository.character


import com.google.gson.annotations.SerializedName

data class GetLocation(
    @SerializedName("results")
    val results: List<Result?>?
)