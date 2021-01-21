package com.example.quickcook.ui.main.dishes.type;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quickcook.databinding.TypeFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.utils.Constants;

public class TypeFragment extends BaseFragment {

    private TypeFragBinding binding;

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

    }

    @Override
    protected void initListener() {

    }
}
