package com.felipe.jokerapp.presentation

import com.felipe.jokerapp.data.CategoryRemoteDataSource
import com.felipe.jokerapp.data.ListCategoryCallback
import com.felipe.jokerapp.model.Category
import com.felipe.jokerapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSuccess(response: List<String>) {
        val categories = response.map { Category(it, 0xFFFF0000) }
        view.showCategories(categories)
    }

    override fun onError(errString: String) {
        view.showError(errString)
    }

    override fun onComplete() {
        view.endProgress()
    }
}