package com.jack.recyclerviewstudy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jack.recyclerviewstudy.R;
import com.jack.recyclerviewstudy.databinding.ItemTextBinding;
import com.jack.recyclerviewstudy.model.Item;

import java.util.Arrays;
import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    List<Item> items;
    LayoutInflater layoutInflater;

    public RecyAdapter(Context context, List<Item> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTextBinding uiBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_text, parent, false);
        return new ViewHolder(uiBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.titleTv.setText(items.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public List<Item> getDataList() {
        return items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemTextBinding binding;
        ViewHolder(ItemTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ItemTextBinding getBinding() {
            return binding;
        }
    }
}
