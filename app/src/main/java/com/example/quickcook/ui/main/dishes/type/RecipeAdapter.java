package com.example.quickcook.ui.main.dishes.type;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quickcook.R;
import com.example.quickcook.data.model.Nutrient;
import com.example.quickcook.data.model.Recipe;
import com.example.quickcook.databinding.ItemRecipeBinding;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final Context mContext;
    private List<Recipe> mRecipes;

    public RecipeAdapter(Context context) {
        this.mContext = context;
        this.mRecipes = new ArrayList<>();
    }

    public void setRecipes(List<Recipe> recipes) {
        this.mRecipes = recipes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecipeBinding binding = ItemRecipeBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new RecipeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = mRecipes.get(position);
        holder.onBind(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        private ItemRecipeBinding mBinding;

        public RecipeViewHolder(@NonNull ItemRecipeBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(Recipe recipe) {
            if (recipe != null) {
                Glide.with(itemView.getContext())
                        .load(recipe.getImage())
                        .placeholder(R.drawable.bg_cinnamon)
                        .circleCrop()
                        .into(mBinding.imgItemRecipe);

                Nutrient nutrient = recipe.getNutrition().getNutrients().get(0);
                mBinding.tvTitleRecipe.setText(recipe.getTitle());
                mBinding.tvNutrition.setText(String.format("%s%s", nutrient.getAmount(), nutrient.getUnit()));
                mBinding.tvTime.setText(String.format("%s%s", recipe.getReadyInMinutes(), "min"));
            }
        }
    }
}
