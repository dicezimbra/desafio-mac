package br.com.testproject.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.testproject.repositories.movie.Movie
import br.com.testproject.repositories.movie.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SplashViewModel(val moviesRepository: MoviesRepository, dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()) {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    val coroutineScope = CoroutineScope(dispatcher)

    fun getMovies() {
        coroutineScope.launch {
            val response =  moviesRepository.getMovies()
            _movie.postValue(response)
        }
    }
}