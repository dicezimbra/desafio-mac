
package br.com.testproject.api.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteRequest {

    @SerializedName("_id")
    @Expose
    public String _id;
    @SerializedName("dialog")
    @Expose
    public String dialog;
    @SerializedName("movie")
    @Expose
    public String movie;
    @SerializedName("character")
    @Expose
    public String character;
    @SerializedName("id")
    @Expose
    public String id;
}
