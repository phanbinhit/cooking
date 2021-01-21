package com.example.quickcook.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quickcook.databinding.SignUpFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.utils.Constants;

public class SignUpFragment extends BaseFragment {

    private SignUpFragBinding binding;

    public static SignUpFragment newInstance(String title) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SignUpFragBinding.inflate(inflater, container, false);
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
