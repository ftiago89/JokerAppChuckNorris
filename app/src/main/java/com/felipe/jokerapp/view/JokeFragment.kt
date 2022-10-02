package com.felipe.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.felipe.jokerapp.R
import com.felipe.jokerapp.model.Joke
import com.felipe.jokerapp.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class JokeFragment : Fragment() {

    private lateinit var presenter: JokePresenter

    private lateinit var progressBar: ProgressBar
    private lateinit var jokeTextView: TextView

    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryName = arguments?.getString(CATEGORY_KEY)!!
        activity?.findViewById<Toolbar>(R.id.toolbar_main)?.title = categoryName
        progressBar = view.findViewById(R.id.joke_progress_bar)
        jokeTextView = view.findViewById(R.id.txt_joke)

        presenter.getJoke(categoryName)

        view.findViewById<FloatingActionButton>(R.id.fab_joke).setOnClickListener {
            presenter.getJoke(categoryName)
        }
    }

    fun showJoke(joke: Joke) {
        jokeTextView.text = joke.value
        //TODO adicionar imagem
    }

    fun showError(errString: String) {
        Toast.makeText(requireContext(), errString, Toast.LENGTH_LONG).show()
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun disableProgressBar() {
        progressBar.visibility = View.INVISIBLE
    }
}