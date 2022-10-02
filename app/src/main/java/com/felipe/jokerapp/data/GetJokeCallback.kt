package com.felipe.jokerapp.data

import com.felipe.jokerapp.model.Joke

interface GetJokeCallback {

    fun onSuccess(joke: Joke)

    fun onError(errString: String)

    fun onComplete()
}