package com.example.quickcook.ui.main.dishes.ingredient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.quickcook.data.model.Ingredient;
import com.example.quickcook.databinding.IngredientFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.utils.Constants;

import java.util.List;

public class IngredientFragment extends BaseFragment {

    private IngredientFragBinding binding;
    private IngredientViewModel mViewModel;
    private List<Ingredient> mIngredients;
    private IngredientAdapter mAdapter;

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

        //initView();
        //initListener();
    }

    @Override
    protected void initView() {
        mViewModel = new ViewModelProvider(this).get(IngredientViewModel.class);
        mViewModel.setIngredientLiveData("drink");

        mAdapter = new IngredientAdapter(getActivity());
        binding.recyclerViewIngredient.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        binding.recyclerViewIngredient.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mViewModel.ingredientLiveData.observe(getViewLifecycleOwner(), ingredients -> {
            mIngredients = ingredients;
            mAdapter.setIngredients(mIngredients);
        });
    }
}
