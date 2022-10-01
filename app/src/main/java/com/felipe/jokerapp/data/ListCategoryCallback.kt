package com.felipe.jokerapp.data

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(errString: String)

    fun onComplete()
}