package com.example.quickcook.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.quickcook.R;
import com.example.quickcook.databinding.MainActBinding;
import com.example.quickcook.ui.base.BaseActivity;
import com.example.quickcook.ui.main.dishes.DishesFragment;
import com.example.quickcook.ui.main.favorites.FavoritesFragment;
import com.example.quickcook.ui.main.plan.PlanMealFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    private MainActBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainActBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initView();
        initListener();
    }

    @Override
    protected void initView() {
        loadFragment(DishesFragment.newInstance(getString(R.string.dish)));
    }

    @Override
    protected void initListener() {
        //set event bottom navigation item selected
        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_dishes:
                        loadFragment(DishesFragment.newInstance(getString(R.string.dish)));
                        return true;
                    case R.id.bottom_nav_plan:
                        loadFragment(PlanMealFragment.newInstance(getString(R.string.plan)));
                        return true;
                    case R.id.bottom_nav_favorites:
                        loadFragment(FavoritesFragment.newInstance(getString(R.string.favorites)));
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.flContainer.getId(), fragment)
                .commit();
    }
}