package com.example.quickcook.ui.main.dishes.ingredient;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quickcook.data.model.Ingredient;
import com.example.quickcook.data.remote.RetrofitClient;
import com.example.quickcook.data.remote.ingredient.IngredientService;
import com.example.quickcook.ui.base.BaseViewModel;
import com.example.quickcook.utils.Constants;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class IngredientViewModel extends BaseViewModel {

    private IngredientService service;

    private MutableLiveData<List<Ingredient>> _ingredientLiveData = new MutableLiveData<>();
    public LiveData<List<Ingredient>> ingredientLiveData = _ingredientLiveData;

    public IngredientViewModel(@NonNull Application application) {
        super(application);
        service = RetrofitClient.getRetrofit(Constants.BASE_URL).create(IngredientService.class);
    }

    public void setIngredientLiveData(String query) {
        service.searchIngredient(Constants.API_KEY, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Ingredient>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Ingredient> ingredients) {
                        if (ingredients != null) {
                            _ingredientLiveData.setValue(ingredients);
                        }
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }
                });
    }
}
