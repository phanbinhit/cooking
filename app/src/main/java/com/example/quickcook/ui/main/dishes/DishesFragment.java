package com.example.quickcook.ui.main.dishes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quickcook.R;
import com.example.quickcook.databinding.DishFragBinding;
import com.example.quickcook.databinding.LoginFragBinding;
import com.example.quickcook.ui.account.LoginFragment;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.ui.main.dishes.ingredient.IngredientFragment;
import com.example.quickcook.ui.main.dishes.type.TypeFragment;
import com.example.quickcook.utils.Constants;

import java.util.Arrays;
import java.util.List;

public class DishesFragment extends BaseFragment {

    private DishFragBinding binding;
    private DishesFragmentAdapter mFragmentAdapter;
    private List<Fragment> mFragments;

    public static DishesFragment newInstance(String title) {
        DishesFragment fragment = new DishesFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DishFragBinding.inflate(inflater, container, false);

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
        mFragments = Arrays.asList(TypeFragment.newInstance(getString(R.string.title_type_fragment)),
                IngredientFragment.newInstance(getString(R.string.title_ingredient_fragment)));
        mFragmentAdapter = new DishesFragmentAdapter(getActivity().getSupportFragmentManager(), mFragments);
        binding.viewPagerDish.setAdapter(mFragmentAdapter);
        binding.tabLayoutDish.setupWithViewPager(binding.viewPagerDish);
    }

    @Override
    protected void initListener() {

    }
}
