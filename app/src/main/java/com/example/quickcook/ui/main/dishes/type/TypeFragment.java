package com.example.quickcook.ui.main.dishes.type;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.quickcook.data.model.Recipe;
import com.example.quickcook.data.model.Type;
import com.example.quickcook.databinding.TypeFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.utils.Constants;

import java.util.Arrays;
import java.util.List;

public class TypeFragment extends BaseFragment {

    private TypeFragBinding binding;

    private RecipeViewModel mViewModel;
    private RecipeAdapter mRecipeAdapter;
    private ButtonTypeAdapter mButtonTypeAdapter;
    private List<Recipe> mRecipes;

    public static TypeFragment newInstance(String title) {
        TypeFragment fragment = new TypeFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TypeFragBinding.inflate(inflater, container, false);
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
        mViewModel = new ViewModelProvider(this).get(RecipeViewModel.class);

        List<Type> types = Arrays.asList(Type.values());
        mButtonTypeAdapter = new ButtonTypeAdapter(getActivity(), types);
        binding.recyclerViewButton.setAdapter(mButtonTypeAdapter);
        binding.recyclerViewButton.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mRecipeAdapter = new RecipeAdapter(getActivity());
        binding.recyclerViewRecipe.setAdapter(mRecipeAdapter);
        binding.recyclerViewRecipe.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initListener() {
//        mViewModel.setRecipesSearchLiveData(Type.BREAKFAST.getType());
//
//        mViewModel.recipesLiveData.observe(getViewLifecycleOwner(), recipes -> {
//            mRecipes = recipes;
//            mRecipeAdapter.setRecipes(recipes);
//        });
    }
}
