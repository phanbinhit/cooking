package com.example.quickcook.ui.main.dishes.ingredient;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.quickcook.data.model.Ingredient;
import com.example.quickcook.databinding.IngredientFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.utils.Constants;

import java.util.List;

public class IngredientFragment extends BaseFragment {

    private IngredientFragBinding binding;
    private IngredientViewModel mViewModel;

    public static IngredientFragment newInstance(String title) {
        IngredientFragment fragment = new IngredientFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = IngredientFragBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initListener();
    }

    @Override
    protected void initView() {
        mViewModel = new ViewModelProvider(this).get(IngredientViewModel.class);
        mViewModel.setIngredientLiveData("vegetable");
        mViewModel.ingredientLiveData.observe(this, new Observer<List<Ingredient>>() {
            @Override
            public void onChanged(List<Ingredient> ingredients) {
                for (Ingredient ingredient : ingredients) {
                    Log.d("INGREDIENT", ingredient.getImage());
                }
            }
        });
    }

    @Override
    protected void initListener() {

    }
}
