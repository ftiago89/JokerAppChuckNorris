package com.felipe.jokerapp.data.datasource

import com.felipe.jokerapp.model.Joke

interface GetJokeCallback {

    fun onSuccess(joke: Joke)

    fun onError(errString: String)

    fun onComplete()
}