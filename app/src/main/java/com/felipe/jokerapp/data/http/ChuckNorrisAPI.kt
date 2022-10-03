package com.felipe.jokerapp.data.http

import com.felipe.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {

    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey: String = HTTPClient.API_KEY): Call<List<String>>

    @GET("jokes/random")
    fun getJoke(@Query("category") category: String? = null, @Query("apiKey") apiKey: String = HTTPClient.API_KEY): Call<Joke>
}