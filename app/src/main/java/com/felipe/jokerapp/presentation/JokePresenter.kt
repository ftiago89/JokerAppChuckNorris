package com.felipe.jokerapp.presentation

import com.felipe.jokerapp.data.GetJokeCallback
import com.felipe.jokerapp.data.JokeRemoteDataSource
import com.felipe.jokerapp.model.Joke
import com.felipe.jokerapp.view.JokeFragment

class JokePresenter(private val view: JokeFragment, private val datasource: JokeRemoteDataSource = JokeRemoteDataSource()) :
    GetJokeCallback {

    fun getJoke(categoryName: String) {
        view.showProgressBar()
        datasource.getJoke(this, categoryName)
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