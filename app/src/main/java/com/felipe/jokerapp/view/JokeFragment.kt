package com.felipe.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.felipe.jokerapp.R

class JokeFragment : Fragment() {

    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = arguments?.get(CATEGORY_KEY)
        activity?.findViewById<Toolbar>(R.id.toolbar_main)?.title = categoryName.toString()
    }
}