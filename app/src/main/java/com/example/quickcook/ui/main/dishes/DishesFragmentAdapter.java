package com.example.quickcook.ui.main.dishes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quickcook.utils.Constants;

import java.util.List;

public class DishesFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public DishesFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Bundle args = mFragments.get(position).getArguments();
        if (args != null) {
            return args.getString(Constants.TITLE_FRAG_KEY);
        }
        return super.getPageTitle(position);
    }
}
