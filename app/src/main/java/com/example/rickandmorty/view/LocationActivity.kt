package com.example.rickandmorty.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.LocationAdapter
import com.example.rickandmorty.repository.location.Location
import com.example.rickandmorty.repository.location.LocationResponse
import com.example.rickandmorty.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val client = ApiClient.apiService.getLocations("1")

        client.enqueue(object : Callback<LocationResponse> {
            override fun onResponse(
                call: Call<LocationResponse>,
                response: Response<LocationResponse>
            ) {
                if (response.isSuccessful) {
                    // Log.i("locations", "" + response.body())
                    val resultLoca = response.body()?.result
                    resultLoca.let {
                        val adapterLoca = LocationAdapter(resultLoca as List<Location>)
                        val recyclerViewLoca =
                            findViewById<RecyclerView>(R.id.location_recycler_view)
                        recyclerViewLoca?.layoutManager = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        recyclerViewLoca.adapter = adapterLoca

                    }
                }
            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                Log.i("failed", "" + t.message)
            }

        })
    }
}