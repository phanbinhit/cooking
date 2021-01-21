package com.example.quickcook.ui.account;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quickcook.R;
import com.example.quickcook.databinding.AccountActBinding;
import com.example.quickcook.ui.base.BaseActivity;

import java.util.Arrays;
import java.util.List;

public class AccountActivity extends BaseActivity {

    private AccountActBinding binding;

    private List<Fragment> mFragments;
    private AccountFragmentAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AccountActBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initView();
        initListener();
    }

    @Override
    protected void initView() {
        mFragments = Arrays.asList(LoginFragment.newInstance(getString(R.string.sign_in)),
                SignUpFragment.newInstance(getString(R.string.sign_up)));
        mAdapter = new AccountFragmentAdapter(getSupportFragmentManager(), mFragments);
        binding.viewPagerAccount.setAdapter(mAdapter);
        binding.tabLayoutAccount.setupWithViewPager(binding.viewPagerAccount);
    }

    @Override
    protected void initListener() {

    }
}
