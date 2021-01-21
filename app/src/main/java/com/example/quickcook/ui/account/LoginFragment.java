package com.example.quickcook.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quickcook.databinding.LoginFragBinding;
import com.example.quickcook.ui.base.BaseFragment;
import com.example.quickcook.ui.main.MainActivity;
import com.example.quickcook.utils.Constants;

public class LoginFragment extends BaseFragment {

    private LoginFragBinding binding;

    public static LoginFragment newInstance(String title) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TITLE_FRAG_KEY, title);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LoginFragBinding.inflate(inflater, container, false);
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
        binding.btnLogin.setOnClickListener(v -> startActivity(new Intent(getActivity(), MainActivity.class)));
    }
}
