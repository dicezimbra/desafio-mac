package br.com.testproject.features.characters

import androidx.paging.PageKeyedDataSource
import br.com.testproject.repositories.character.CharacterItem
import br.com.testproject.repositories.character.CharactersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CharacterDataSource(val charactersRepository: CharactersRepository, dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()) : PageKeyedDataSource<Int, CharacterItem>() {

    private val coroutineScope = CoroutineScope(dispatcher)
    val PAGE_SIZE = 50
    private var FIRST_PAGE = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharacterItem>
    ) {
        coroutineScope.launch {
            val result = charactersRepository?.getCharacters(1, PAGE_SIZE)
            callback.onResult(result.docs,null, FIRST_PAGE + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharacterItem>
    ) {
        coroutineScope.launch {
            val result = charactersRepository?.getCharacters(params.key, PAGE_SIZE)

            if (params.key > 1) {
                Integer(params.key.toInt() - 1)
                callback.onResult(result.docs,params.key - 1)
            }else{
                callback.onResult(result.docs,null)
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharacterItem>
    ) {
        coroutineScope.launch {
            val result = charactersRepository?.getCharacters(params.key, PAGE_SIZE)
            if(result.page > result.pages){
                callback.onResult(result.docs, null)
            }else{
                callback.onResult(result.docs, params.key + 1)
            }
        }
    }

}