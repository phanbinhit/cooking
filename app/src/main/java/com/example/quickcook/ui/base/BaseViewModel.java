package com.example.quickcook.ui.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BaseViewModel extends AndroidViewModel {

    protected CompositeDisposable disposable = new CompositeDisposable();
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}
