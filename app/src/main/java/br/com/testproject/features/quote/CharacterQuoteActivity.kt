package br.com.testproject.features.quote

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.repositories.character.CharacterItem
import br.com.testproject.repositories.character.Quote
import org.koin.android.ext.android.inject

class CharacterQuoteActivity : AppCompatActivity() {

    private val viewModel: CharacterQuoteViewModel by inject()
    private var quoteAdapter: QuotesAdapter? = null

    companion object {

        private const val characterId = "characterId"
        private const val character = "character"
        fun newInstance(context: Context, doc: CharacterItem): Intent {
            val intent = Intent(context, CharacterQuoteActivity::class.java)
            intent.putExtra(characterId, doc.id)
            intent.putExtra(character, doc)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_quote)

        viewModel?.quote?.observe(this){
            fillQuotes(it)
        }

        intent.extras?.getString(characterId)?.let {
            viewModel?.getCharacterQuotes(it)
        }

        intent.extras?.getSerializable(character)?.let {
            if(it is CharacterItem)
                fillView(it)
        }
    }

    private fun fillQuotes(quotes: Quote?) {
        quoteAdapter = QuotesAdapter()
        quotes?.docs?.let { quoteAdapter?.quotes?.addAll(it) }
        val rvQuotes: RecyclerView = findViewById(R.id.rvQuotes)
        rvQuotes.adapter = quoteAdapter
    }

    private fun fillView(character: CharacterItem) {
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvHeight: TextView = findViewById(R.id.tv_height)
        val tv_race: TextView = findViewById(R.id.tv_race)
        val tv_gender: TextView = findViewById(R.id.tv_gender)
        val tv_birth: TextView = findViewById(R.id.tv_birth)
        val tv_spouse: TextView = findViewById(R.id.tv_spouse)
        val tv_death: TextView = findViewById(R.id.tv_death)
        val tv_realm: TextView = findViewById(R.id.tv_realm)
        val tv_hair: TextView = findViewById(R.id.tv_hair)
        val tv_wikiUrl: TextView = findViewById(R.id.tv_wikiUrl)

        tvName.text = "${character?.name}"
        tv_race.text = "Race: ${character?.race}"
        tv_gender.text = "Gender: ${character?.gender}"
        tv_birth.text = "Birth: ${character?.birth}"
        tv_spouse.text = "Spouse: ${character?.spouse}"
        tv_death.text = "Death: ${character?.death}"
        tv_realm.text = "Realm: ${character?.realm}"
        tv_hair.text = "Hair: ${character?.hair}"
        tv_wikiUrl.text = "Wiki URL: ${character?.wikiUrl}"
        tvHeight.text = "Height: ${character?.height}"
    }
}