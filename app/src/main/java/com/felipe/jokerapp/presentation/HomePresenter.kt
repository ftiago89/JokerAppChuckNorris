package com.felipe.jokerapp.presentation

import android.graphics.Color
import com.felipe.jokerapp.data.datasource.CategoryRemoteDataSource
import com.felipe.jokerapp.data.datasource.ListCategoryCallback
import com.felipe.jokerapp.model.Category
import com.felipe.jokerapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment, private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }


    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val step = (end - start) / response.size
        val categories = response.mapIndexed { index, value ->
            val hsv = floatArrayOf((start + (step * index)).toFloat(), 100.0f, 100.0f)
            Category(value, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onError(errString: String) {
        view.showError(errString)
    }

    override fun onComplete() {
        view.endProgress()
    }
}