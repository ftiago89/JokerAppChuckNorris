package com.felipe.jokerapp.data.datasource

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(errString: String)

    fun onComplete()
}