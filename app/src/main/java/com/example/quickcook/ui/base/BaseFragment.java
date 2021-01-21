package com.example.quickcook.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected abstract void initView();

    protected abstract void initListener();

    protected boolean changeFragment() {
        return false;
    }

    protected boolean backFragment() {
        return false;
    }
}
