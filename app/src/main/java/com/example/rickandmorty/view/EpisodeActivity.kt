package com.example.rickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.EpisodeAdapter
import com.example.rickandmorty.repository.episode.Episode
import com.example.rickandmorty.repository.episode.EpisodeResponse
import com.example.rickandmorty.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)


        val client = ApiClient.apiService.getEpisode("1")

        client.enqueue(object : Callback<EpisodeResponse> {
            override fun onResponse(
                call: Call<EpisodeResponse>,
                response: Response<EpisodeResponse>
            ) {
                if (response.isSuccessful) {
                    // Log.i("locations", "" + response.body())
                    val resultEpi = response.body()?.result
                    resultEpi.let {
                        val adapterEpi = EpisodeAdapter(resultEpi as List<Episode>)
                        val recyclerViewEpi = findViewById<RecyclerView>(R.id.location_recycler_view)
                        recyclerViewEpi?.layoutManager = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        recyclerViewEpi.adapter = adapterEpi

                    }
                }
            }


            override fun onFailure(call: Call<EpisodeResponse>, t: Throwable) {
                Log.i("failed", "" + t.message)
            }

        })
    }
}