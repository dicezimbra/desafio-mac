package br.com.testproject

import android.app.Application
import br.com.testproject.api.movies.MoviesApi
import br.com.testproject.features.characters.CharacterItemDataSourceFactory
import br.com.testproject.features.characters.CharactersViewModel
import br.com.testproject.features.quote.CharacterQuoteViewModel
import br.com.testproject.features.splash.SplashViewModel
import br.com.testproject.remote.HttpClient
import br.com.testproject.repositories.character.CharactersRepository
import br.com.testproject.repositories.movie.MoviesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@TestApplication)
            modules(appModule)
        }
    }

    val appModule = module {
        factory { HttpClient() }
        factory { get<HttpClient>().create(MoviesApi::class.java) }
        factory { MoviesRepository(get()) }
        factory { CharactersRepository(get()) }
        factory { SplashViewModel(get()) }
        factory { CharactersViewModel(get()) }
        factory { CharacterQuoteViewModel(get()) }
        factory { CharacterItemDataSourceFactory(get()) }
    }
}

