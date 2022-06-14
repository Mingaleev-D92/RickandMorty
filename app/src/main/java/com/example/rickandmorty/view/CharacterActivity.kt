package com.example.rickandmorty.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.CharacterAdapter
import com.example.rickandmorty.network.ApiClient
import com.example.rickandmorty.repository.character.GetLocation
import retrofit2.Call
import retrofit2.Response

class CharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)


        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object : retrofit2.Callback<GetLocation> {

            override fun onResponse(
                call: Call<GetLocation>,
                response: Response<GetLocation>
            ) {
                if (response.isSuccessful) {

                    val result = response.body()?.results
                    result?.let {
                        val adapter = CharacterAdapter(result)
                        val recyclerView = findViewById<RecyclerView>(R.id.characters_recycler_view)
                        recyclerView?.layoutManager = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        recyclerView?.adapter = adapter
                    }

                }
            }

            override fun onFailure(call: Call<GetLocation>, t: Throwable) {
                Log.i("failed", "" + t.message)
            }
        })
    }


}




