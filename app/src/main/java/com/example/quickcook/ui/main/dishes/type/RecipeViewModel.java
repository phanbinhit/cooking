package com.example.quickcook.ui.main.dishes.type;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quickcook.data.model.Recipe;
import com.example.quickcook.data.model.Result;
import com.example.quickcook.data.remote.ApiService;
import com.example.quickcook.data.remote.RetrofitClient;
import com.example.quickcook.ui.base.BaseViewModel;
import com.example.quickcook.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RecipeViewModel extends BaseViewModel {

    private ApiService service;

    private MutableLiveData<List<Recipe>> _recipesSearchLiveData = new MutableLiveData<>();
    public LiveData<List<Recipe>> recipesSearchLiveData = _recipesSearchLiveData;

    private MutableLiveData<List<Recipe>> _recipesLiveData = new MutableLiveData<>();
    public LiveData<List<Recipe>> recipesLiveData = _recipesLiveData;

    public RecipeViewModel(@NonNull Application application) {
        super(application);

        _recipesLiveData.setValue(new ArrayList<>());
        _recipesSearchLiveData.setValue(new ArrayList<>());
        service = RetrofitClient.getRetrofit(Constants.BASE_URL).create(ApiService.class);
    }

    public synchronized void setRecipesSearchLiveData(String type) {
        service.searchRecipeByType(Constants.API_KEY, type, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Result<Recipe>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Result<Recipe> recipeResult) {
                        _recipesSearchLiveData.setValue(recipeResult.getList());
                        setRecipesLiveData();
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }

    public void setRecipesLiveData() {
        for (Recipe recipe : _recipesSearchLiveData.getValue()) {
            service.getRecipeById(recipe.getId(), Constants.API_KEY, true)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<Recipe>() {
                        @Override
                        public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                            disposable.add(d);
                        }

                        @Override
                        public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull Recipe recipe) {
                            List<Recipe> recipes = _recipesLiveData.getValue();
                            recipes.add(recipe);
                            _recipesLiveData.setValue(recipes);
                        }

                        @Override
                        public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                        }
                    });
        }
    }
}
