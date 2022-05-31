package br.com.testproject.features.splash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.repositories.movie.MovieItem

class MoviesAdapter(val onMovieClick : (MovieItem) -> Unit ) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: MutableList<MovieItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    class ViewHolder (view: View, val onMovieClick : (MovieItem) -> Unit) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvruntimeInMinutes: TextView = view.findViewById(R.id.tv_runtimeInMinutes)
        private val tvbudgetInMillions: TextView = view.findViewById(R.id.tv_budgetInMillions)
        private val tvboxOfficeRevenueInMillions: TextView = view.findViewById(R.id.tv_boxOfficeRevenueInMillions)
        private val tvacademyAwardNominations: TextView = view.findViewById(R.id.tv_academyAwardNominations)
        private val tvacademyAwardWins: TextView = view.findViewById(R.id.tv_academyAwardWins)
        private val tvrottenTomatoesScore: TextView = view.findViewById(R.id.tv_rottenTomatoesScore)
        private val cvfullContent: CardView = view.findViewById(R.id.cvfullContentMovie)

        fun bind(movie: MovieItem?) {
            tvName.text = movie?.name
            tvruntimeInMinutes.text = "Total: ${movie?.runtimeInMinutes} minutes"
            tvbudgetInMillions.text = "Budget: $${movie?.budgetInMillions} millions"
            tvboxOfficeRevenueInMillions.text = "Box Office Revenue: $${movie?.boxOfficeRevenueInMillions} millions"
            tvacademyAwardNominations.text = "Academy Award Nominations: ${movie?.academyAwardNominations}"
            tvacademyAwardWins.text = "Academy Wins: ${movie?.academyAwardWins}"
            tvrottenTomatoesScore.text = "Rotten Tomatoes Score: ${movie?.rottenTomatoesScore}"

            cvfullContent.setOnClickListener {
                movie?.let(onMovieClick)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view, onMovieClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies.getOrNull(position))
    }

    override fun getItemCount(): Int {
       return movies.size
    }

}