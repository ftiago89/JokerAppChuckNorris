package com.felipe.jokerapp.presentation

import android.os.Handler
import android.os.Looper
import com.felipe.jokerapp.model.Category
import com.felipe.jokerapp.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4",
            )

            onSuccess(response)
            onCompleted()
        }, 4000)
    }

    private fun onSuccess(response: List<String>) {
        val categories = response.map { Category(it, 0xFFFF0000) }
        view.showCategories(categories)
    }

    private fun onError(errString: String) {
        view.showError(errString)
    }

    private fun onCompleted() {
        view.endProgress()
    }
}