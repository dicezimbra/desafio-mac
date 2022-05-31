
package br.com.testproject.api.movies;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterRequest {

    @SerializedName("docs")
    @Expose
    public List<CharacterItemRequest> docs = null;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("limit")
    @Expose
    public Integer limit;
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("pages")
    @Expose
    public Integer pages;

}
