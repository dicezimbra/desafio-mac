package br.com.testproject.api.movies;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieRequest {

    @SerializedName("docs")
    @Expose
    public List<MovieItemRequest> docs = null;
    @SerializedName("total")
    @Expose
    public Double total;
    @SerializedName("limit")
    @Expose
    public Double limit;
    @SerializedName("offset")
    @Expose
    public Double offset;
    @SerializedName("page")
    @Expose
    public Double page;
    @SerializedName("pages")
    @Expose
    public Double pages;

}
