package com.example.daniel.discovermovies_2.api;

import com.example.daniel.discovermovies_2.model.SearchModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel on 4/27/17.
 */

public interface SearchService {
    @GET("/search/movie")
    Call<SearchModel> getSearch(
            @Query("api-key") String apiKey,
            @Query("query") String movieName,
            @Query("language") String language
    );
}
