package com.jack.recyclerviewstudy.adapter;

import android.content.Context;

import com.jack.recyclerviewstudy.R;
import com.jack.recyclerviewstudy.databinding.ItemTextBinding;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.Item;

//ItemTextBinding 是根据layout(item_text)生成的类
public class SimpleAdapter extends BaseBindingAdapter<Item, ItemTextBinding> {
    private final String TAG = SimpleAdapter.class.getSimpleName();
    private ItemClickListener listener;
    public SimpleAdapter(Context context, ItemClickListener listener) {
        super(context);
        this.listener = listener;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_text;
    }

    @Override
    protected void onBindItem(ItemTextBinding binding, Item itemData, int position) {
        binding.setPos(position);
        binding.titleTv.setText(itemData.getData());
        binding.itemLl.setOnClickListener((view)->{
            if (listener != null) {
                listener.itemClick(position);
            }
        });
        binding.executePendingBindings();
    }
}
