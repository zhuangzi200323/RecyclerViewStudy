package com.jack.recyclerviewstudy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jack.recyclerviewstudy.R;
import com.jack.recyclerviewstudy.databinding.ItemText2Binding;
import com.jack.recyclerviewstudy.databinding.ItemTextBinding;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.Item;

import java.util.List;

public class SimpleAdapterWithViewType extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    String TAG = SimpleAdapterWithViewType.class.getSimpleName();

    public static enum ITEM_TYPE {
        ITEM_TYPE_TEXT2,
        ITEM_TYPE_TEXT
    }

    LayoutInflater layoutInflater;
    List<Item> items;
    ItemClickListener listener;

    public SimpleAdapterWithViewType(Context context, List<Item> items, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.listener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_TEXT2.ordinal()) {
            return new TextViewHolder2(DataBindingUtil.inflate(layoutInflater, R.layout.item_text2, parent, false));
        } else {
            return new TextViewHolder1(DataBindingUtil.inflate(layoutInflater, R.layout.item_text, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder1) {
            ((TextViewHolder1) holder).binding.setPos(position);
            ((TextViewHolder1) holder).binding.titleTv.setText(items.get(position).getData());
        } else if (holder instanceof TextViewHolder2) {
            ((TextViewHolder2) holder).binding.setPos(position);
            ((TextViewHolder2) holder).binding.beforeTv.setText(items.get(position).getData().substring(0, items.get(position).getData().length()/2));
            ((TextViewHolder2) holder).binding.afterTv.setText(items.get(position).getData().substring(items.get(position).getData().length()/2));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_TEXT2.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TextViewHolder1 extends RecyclerView.ViewHolder{
        ItemTextBinding binding;

        TextViewHolder1(ItemTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener((v)->{
                if (listener != null){
                    Log.e(TAG, "#### getAdapterPosition = " + getAdapterPosition());
                    listener.itemClick(getAdapterPosition());
                }
            });
        }
    }

    public class TextViewHolder2 extends RecyclerView.ViewHolder{
        ItemText2Binding binding;

        TextViewHolder2(ItemText2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener((v)->{
                if (listener != null){
                    Log.e(TAG, "#### getAdapterPosition = " + getAdapterPosition());
                    listener.itemClick(getAdapterPosition());
                }
            });
        }
    }
}
