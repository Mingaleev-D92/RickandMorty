package com.example.rickandmorty.network

import com.example.rickandmorty.repository.location.LocationResponse
import com.example.rickandmorty.repository.character.GetLocation
import com.example.rickandmorty.repository.episode.EpisodeResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Mingaleev D. 11.06.2022
 **/
object ApiClient {
    private val BASE_URL = "https://rickandmortyapi.com/api/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("character")
    fun fetchCharacters(@Query("page") page: String): Call<GetLocation>

    @GET("location")
    fun getLocations(@Query("page") page:String): Call<LocationResponse>

    @GET("episode")
    fun getEpisode(@Query("page") page:String): Call<EpisodeResponse>
}