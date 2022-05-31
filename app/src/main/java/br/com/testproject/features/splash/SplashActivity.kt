package br.com.testproject.features.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.features.characters.CharactersActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by inject()
    private var movieAdapter : MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val rvMovies = findViewById<RecyclerView>(R.id.rv_movies)

        movieAdapter = MoviesAdapter {
            startActivity(CharactersActivity.newInstance(this))
            finish()
        }

        rvMovies.adapter = movieAdapter

        viewModel?.movie?.observe(this){ movie ->
            movie?.docs?.let { movies ->
                movieAdapter?.movies = movies.toMutableList()
            }
        }

        viewModel.getMovies()
    }
}