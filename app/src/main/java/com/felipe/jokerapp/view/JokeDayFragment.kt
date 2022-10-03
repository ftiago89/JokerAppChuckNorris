package com.felipe.jokerapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.felipe.jokerapp.R
import com.felipe.jokerapp.model.Joke
import com.felipe.jokerapp.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment() {

    private lateinit var presenter: JokeDayPresenter

    private lateinit var progressBar: ProgressBar
    private lateinit var jokeTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokeDayPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<Toolbar>(R.id.toolbar_main)?.title = getString(R.string.menu_joke_day)

        progressBar = view.findViewById(R.id.joke_day_progress_bar)
        jokeTextView = view.findViewById(R.id.txt_joke_day)
        imageView = view.findViewById(R.id.img_joke_day)

        presenter.getJoke()
    }

    fun showJoke(joke: Joke) {
        jokeTextView.text = joke.value
        Picasso.get().load(joke.iconUrl).into(imageView)
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