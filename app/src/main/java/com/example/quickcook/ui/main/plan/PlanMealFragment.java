package com.example.quickcook.ui.main.plan;

import android.os.Bundle;

import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.ui.main.dishes.DishesFragment;
import com.example.quickcook.utils.Constants;

public class PlanMealFragment extends BaseFragment {

    public static PlanMealFragment newInstance(String title) {
        PlanMealFragment fragment = new PlanMealFragment();
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
