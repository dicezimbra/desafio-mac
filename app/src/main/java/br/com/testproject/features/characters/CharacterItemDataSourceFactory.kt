package br.com.testproject.features.characters

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import br.com.testproject.repositories.character.CharacterItem
import br.com.testproject.repositories.character.CharactersRepository


class CharacterItemDataSourceFactory(private val charactersRepository: CharactersRepository): DataSource.Factory<Int, CharacterItem>() {

    private val characterLiveDataSource : MutableLiveData<PageKeyedDataSource<Int, CharacterItem>> = MutableLiveData()

    override fun create(): DataSource<Int, CharacterItem> {
        val itemDataSource = CharacterDataSource(charactersRepository)
        characterLiveDataSource?.postValue(itemDataSource)
        return itemDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, CharacterItem>> {
        return characterLiveDataSource
    }
}