package com.jack.recyclerviewstudy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.ToastUtils;
import com.jack.recyclerviewstudy.adapter.SimpleAdapterWithViewType;
import com.jack.recyclerviewstudy.adapter.SimpleUseAdapter;
import com.jack.recyclerviewstudy.databinding.ActivitySimpleUseWithItemLineBinding;
import com.jack.recyclerviewstudy.decorationline.LeftAndRightTagDecoration;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.FakeData;

public class SimpleUseWithViewTypeActivity extends BaseActivity implements ItemClickListener {
    ActivitySimpleUseWithItemLineBinding uiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_use_with_item_line);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        uiBinding.simpleUseRv.setLayoutManager(linearLayoutManager);

        SimpleAdapterWithViewType simpleAdapterWithViewType = new SimpleAdapterWithViewType(this, FakeData.items2, this);
        uiBinding.simpleUseRv.setAdapter(simpleAdapterWithViewType);
    }

    @Override
    public void itemClick(int pos) {
        ToastUtils.showShort(FakeData.items2.get(pos).getData(), Toast.LENGTH_SHORT);
    }
}