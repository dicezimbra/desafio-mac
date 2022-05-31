
package br.com.testproject.api.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterQuoteRequest {

    @SerializedName("docs")
    @Expose
    public List<QuoteRequest> docs = null;
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
    @SerializedName("offset")
    @Expose
    public Integer offset;
}
