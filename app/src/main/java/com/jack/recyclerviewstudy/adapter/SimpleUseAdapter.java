package com.jack.recyclerviewstudy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.jack.recyclerviewstudy.R;
import com.jack.recyclerviewstudy.databinding.ItemTextBinding;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.Item;

import java.util.List;

public class SimpleUseAdapter extends RecyclerView.Adapter<SimpleUseAdapter.MyViewHolder> {
    String TAG = SimpleUseAdapter.class.getSimpleName();
    LayoutInflater layoutInflater;
    List<Item> items;
    ItemClickListener listener;

    public SimpleUseAdapter(Context context, List<Item> items, ItemClickListener itemClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.listener = itemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new MyViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
        ItemTextBinding uiBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_text, parent, false);
        return new MyViewHolder(uiBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.textView.setText(items.get(position).getData());
        holder.binding.setPos(position);
        holder.binding.titleTv.setText(items.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView textView;
        ItemTextBinding binding;

        MyViewHolder(ItemTextBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener((v)->{
                if (listener != null){
                    Log.e(TAG, "#### getAdapterPosition = " + getAdapterPosition());
                    listener.itemClick(getAdapterPosition());
                }
            });
        }
//        MyViewHolder(View view) {
//            super(view);
//            textView = view.findViewById(R.id.title_tv);
//            view.setOnClickListener((v)->{
//                if (listener != null){
//                    listener.itemClick(getAdapterPosition());
//                }
//            });
//        }
    }
}
