package br.com.testproject.features.characters

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import br.com.testproject.repositories.character.CharacterItem
import br.com.testproject.repositories.character.CharactersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class CharactersViewModel(private val characterItemDataSourceFactory: CharacterItemDataSourceFactory, dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()) {

    var character: LiveData<PagedList<CharacterItem>>
    var liveDataSource: LiveData<PageKeyedDataSource<Int, CharacterItem>>
    val coroutineScope = CoroutineScope(dispatcher)

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30).build()

        liveDataSource = characterItemDataSourceFactory.getItemLiveDataSource()
        var livePagedListBuilder = LivePagedListBuilder(characterItemDataSourceFactory, pagedListConfig)
            .build()

        character = livePagedListBuilder
    }

    fun getCharacters() {
        coroutineScope.launch {

        }
    }
}