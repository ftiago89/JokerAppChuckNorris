package com.felipe.jokerapp.data

import com.felipe.jokerapp.data.http.ChuckNorrisAPI
import com.felipe.jokerapp.data.http.HTTPClient
import com.felipe.jokerapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeDayRemoteDataSource() {

    fun getJoke(callback: GetJokeCallback) {
        HTTPClient.retrofit()
            .create(ChuckNorrisAPI::class.java)
            .getJoke()
            .enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() ?: throw RuntimeException("Piada não encontrada"))
                    } else {
                        callback.onError(response.errorBody()?.string() ?: "Erro desconhecido")
                    }

                    callback.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callback.onError(t.message ?: "Erro interno")
                }

            })
    }
}