package com.example.quickcook.data.remote.ingredient;

import com.example.quickcook.data.model.Ingredient;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IngredientService {
    @GET("food/ingredients/search")
    Single<List<Ingredient>> searchIngredient(@Query("apiKey") String apiKey, @Query("query") String query);
}
