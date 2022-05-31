package br.com.testproject.features.characters

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.features.quote.CharacterQuoteActivity
import br.com.testproject.repositories.character.Character
import br.com.testproject.repositories.movie.MovieItem
import org.koin.android.ext.android.inject

class CharactersActivity : AppCompatActivity() {

    private val viewModel: CharactersViewModel by inject()
    private var charactersAdapter : CharactersAdapter? = null

    companion object {

        fun newInstance(context: Context): Intent{
            val intent = Intent(context, CharactersActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        val rvCharacters = findViewById<RecyclerView>(R.id.rv_characters)

         charactersAdapter = CharactersAdapter {
            startActivity(CharacterQuoteActivity.newInstance(this, it))
            finish()
        }

        rvCharacters.adapter = charactersAdapter
        viewModel?.character?.observe(this){ character ->
            character?.let { characters ->
                charactersAdapter?.submitList(characters)
            }
        }
    }
}