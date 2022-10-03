package com.felipe.jokerapp.presentation

import com.felipe.jokerapp.data.datasource.GetJokeCallback
import com.felipe.jokerapp.data.datasource.JokeDayRemoteDataSource
import com.felipe.jokerapp.model.Joke
import com.felipe.jokerapp.view.JokeDayFragment

class JokeDayPresenter(private val view: JokeDayFragment, private val datasource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()) :
    GetJokeCallback {
    fun getJoke() {
        view.showProgressBar()
        datasource.getJoke(this)
    }

    override fun onSuccess(joke: Joke) {
        view.showJoke(joke)
    }

    override fun onError(errString: String) {
        view.showError(errString)
    }

    override fun onComplete() {
        view.disableProgressBar()
    }
}