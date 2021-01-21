package com.example.quickcook.ui.main.favorites;

import android.os.Bundle;

import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.ui.main.plan.PlanMealFragment;
import com.example.quickcook.utils.Constants;

public class FavoritesFragment extends BaseFragment {

    public static FavoritesFragment newInstance(String title) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }
}
