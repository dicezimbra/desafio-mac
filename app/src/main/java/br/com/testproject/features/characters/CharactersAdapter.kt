package br.com.testproject.features.characters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.testproject.R
import br.com.testproject.repositories.character.CharacterItem

class CharactersAdapter(val onCharacterClick: (CharacterItem) -> Unit) : PagedListAdapter<CharacterItem, CharactersAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<CharacterItem>() {
            override fun areItemsTheSame(oldCharacter: CharacterItem,
                                         newCharacter: CharacterItem) : Boolean {
                return oldCharacter.id == newCharacter.id}

            override fun areContentsTheSame(oldCharacter: CharacterItem,
                                            newCharacter: CharacterItem): Boolean {
                return oldCharacter.equals(newCharacter)
            }
        }
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvHeight: TextView = view.findViewById(R.id.tv_height)
        private val tv_race: TextView = view.findViewById(R.id.tv_race)
        private val tv_gender: TextView = view.findViewById(R.id.tv_gender)
        private val tv_birth: TextView = view.findViewById(R.id.tv_birth)
        private val tv_spouse: TextView = view.findViewById(R.id.tv_spouse)
        private val tv_death: TextView = view.findViewById(R.id.tv_death)
        private val tv_realm: TextView = view.findViewById(R.id.tv_realm)
        private val tv_hair: TextView = view.findViewById(R.id.tv_hair)
        private val tv_wikiUrl: TextView = view.findViewById(R.id.tv_wikiUrl)
        private val cvfullContent: CardView = view.findViewById(R.id.cvfullContentCharacter)

        fun bind(character: CharacterItem? , onCharacterClick: (CharacterItem) -> Unit) {
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

            cvfullContent.setOnClickListener {
                character?.let(onCharacterClick)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onCharacterClick)
    }
}