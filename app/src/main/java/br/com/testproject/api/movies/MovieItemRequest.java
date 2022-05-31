
package br.com.testproject.api.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieItemRequest {

    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("runtimeInMinutes")
    @Expose
    public Double runtimeInMinutes;
    @SerializedName("budgetInMillions")
    @Expose
    public Double budgetInMillions;
    @SerializedName("boxOfficeRevenueInMillions")
    @Expose
    public Double boxOfficeRevenueInMillions;
    @SerializedName("academyAwardNominations")
    @Expose
    public Double academyAwardNominations;
    @SerializedName("academyAwardWins")
    @Expose
    public Double academyAwardWins;
    @SerializedName("rottenTomatoesScore")
    @Expose
    public Double rottenTomatoesScore;

}
