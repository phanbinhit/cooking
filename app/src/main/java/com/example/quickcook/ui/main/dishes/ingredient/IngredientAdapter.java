package com.example.quickcook.ui.main.dishes.ingredient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quickcook.R;
import com.example.quickcook.data.model.Ingredient;
import com.example.quickcook.databinding.ItemIngredientBinding;
import com.example.quickcook.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private List<Ingredient> mIngredients;
    private final Context mContext;

    public IngredientAdapter(Context context) {
        this.mContext = context;
        this.mIngredients = new ArrayList<>();
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.mIngredients = ingredients;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemIngredientBinding binding = ItemIngredientBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new IngredientViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Ingredient ingredient = mIngredients.get(position);
        holder.onBind(ingredient);
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {
        ItemIngredientBinding mBinding;

        public IngredientViewHolder(@NonNull ItemIngredientBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(Ingredient ingredient) {
            if (ingredient != null) {
                mBinding.tvItemIngredient.setText(ingredient.getName());
                Glide.with(itemView.getContext())
                        .load(String.format(Constants.INGREDIENT_IMAGE_URL, ingredient.getImage()))
                        .circleCrop()
                        .placeholder(R.drawable.bg_cinnamon)
                        .into(mBinding.imgItemIngredient);
            }
        }
    }
}
