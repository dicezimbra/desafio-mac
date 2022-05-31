package br.com.testproject.repositories.character

import br.com.testproject.api.movies.CharacterItemRequest
import br.com.testproject.api.movies.CharacterRequest
import java.io.Serializable

class Character(
  var docs: List<CharacterItem>,
    var total: Int,
    var limit: Int,
    var page: Int,
    var pages: Int
)

class CharacterItem(
    var id: String,
    var height: String ,
    var race: String,
    var gender: String,
    var birth: String,
    var spouse: String,
    var death: String ,
    var realm: String,
    var hair: String,
    var name: String,
    var wikiUrl: String
): Serializable

fun CharacterRequest.map(): Character {
    return Character(
        docs = this.docs.map { it.map() },
        total = this.total,
        limit = this.limit,
        page = this.page,
        pages = this.pages
    )
}

fun CharacterItemRequest.map(): CharacterItem {
    return CharacterItem(
        id = this.id.checkNullOrEmpty(),
        height = this.height.checkNullOrEmpty(),
        race = this.race.checkNullOrEmpty(),
        gender = this.gender.checkNullOrEmpty(),
        birth = this.birth.checkNullOrEmpty(),
        spouse = this.spouse.checkNullOrEmpty(),
        death = this.death.checkNullOrEmpty(),
        realm = this.realm.checkNullOrEmpty(),
        hair = this.hair.checkNullOrEmpty(),
        name = this.name.checkNullOrEmpty(),
        wikiUrl = this.wikiUrl.checkNullOrEmpty()
    )
}

fun String?.checkNullOrEmpty(): String {
    return if(this.isNullOrEmpty()) {
        "Missing information"
    }
    else{
        this
    }
}
