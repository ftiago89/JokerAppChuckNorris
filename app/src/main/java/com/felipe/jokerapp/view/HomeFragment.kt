package com.felipe.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.felipe.jokerapp.R
import com.felipe.jokerapp.model.Category
import com.felipe.jokerapp.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomePresenter
    private lateinit var progressBar: ProgressBar

    private val adapter = GroupieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.home_progress_bar)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        presenter.findAllCategories()
    }

    fun showCategories(categories: List<Category>) {
        adapter.addAll(categories.map { CategoryItem(it) })
        adapter.notifyDataSetChanged()
    }

    fun showError(errString: String) {
        Toast.makeText(requireContext(), errString, Toast.LENGTH_LONG).show()
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun endProgress() {
        progressBar.visibility = View.INVISIBLE
    }
}