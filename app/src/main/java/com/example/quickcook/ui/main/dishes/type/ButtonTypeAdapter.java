package com.example.quickcook.ui.main.dishes.type;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickcook.data.model.Type;
import com.example.quickcook.databinding.ItemButtonTypeBinding;

import java.util.List;

public class ButtonTypeAdapter extends RecyclerView.Adapter<ButtonTypeAdapter.ButtonTypeViewHolder> {

    private Context mContext;
    private List<Type> mTypes;

    public ButtonTypeAdapter(Context context, List<Type> types) {
        this.mContext = context;
        this.mTypes = types;
    }

    @NonNull
    @Override
    public ButtonTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemButtonTypeBinding binding = ItemButtonTypeBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new ButtonTypeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonTypeViewHolder holder, int position) {
        String type = mTypes.get(position).getType();
        holder.onBind(type);
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    public class ButtonTypeViewHolder extends RecyclerView.ViewHolder {

        private ItemButtonTypeBinding mBinding;

        public ButtonTypeViewHolder(@NonNull ItemButtonTypeBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(String type) {
            mBinding.btnItemType.setText(type);
        }
    }
}
