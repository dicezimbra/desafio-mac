
package br.com.testproject.api.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterItemRequest {

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("race")
    @Expose
    public String race;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("birth")
    @Expose
    public String birth;
    @SerializedName("spouse")
    @Expose
    public String spouse;
    @SerializedName("death")
    @Expose
    public String death;
    @SerializedName("realm")
    @Expose
    public String realm;
    @SerializedName("hair")
    @Expose
    public String hair;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("wikiUrl")
    @Expose
    public String wikiUrl;

}
