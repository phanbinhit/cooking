package com.example.quickcook.data.remote;

import com.bumptech.glide.request.SingleRequest;
import com.example.quickcook.data.model.Ingredient;
import com.example.quickcook.data.model.Recipe;
import com.example.quickcook.data.model.Result;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //search ingredients
    @GET("food/ingredients/search")
    Single<Result<Ingredient>> searchIngredient(
            @Query("apiKey") String apiKey,
            @Query("query") String query);

    //search recipes by type
    @GET("recipes/complexSearch")
    Single<Result<Recipe>> searchRecipeByType(
            @Query("apiKey") String apiKey,
            @Query("type") String type,
            @Query("number") int number);

    //get information by id
    @GET("recipes/{id}/information")
    Single<Recipe> getRecipeById(
            @Path("id") Integer id,
            @Query("apiKey") String apiKey,
            @Query("includeNutrition") boolean includeNutrition);
}
