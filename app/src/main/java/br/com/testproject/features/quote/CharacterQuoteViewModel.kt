package br.com.testproject.features.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.testproject.repositories.character.CharactersRepository
import br.com.testproject.repositories.character.Quote
import br.com.testproject.repositories.movie.Movie
import br.com.testproject.repositories.movie.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CharacterQuoteViewModel(val charactersRepository: CharactersRepository, dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()) {

    private val _quote = MutableLiveData<Quote>()
    val quote: LiveData<Quote> = _quote

    val coroutineScope = CoroutineScope(dispatcher)

    fun getCharacterQuotes(id: String) {
        coroutineScope.launch {
            val response =  charactersRepository.getCharactersQuote(id)
            _quote.postValue(response)
        }
    }
}