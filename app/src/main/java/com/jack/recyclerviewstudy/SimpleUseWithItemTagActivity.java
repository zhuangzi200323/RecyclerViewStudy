package com.jack.recyclerviewstudy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.ToastUtils;
import com.jack.recyclerviewstudy.adapter.SimpleUseAdapter;
import com.jack.recyclerviewstudy.databinding.ActivitySimpleUseWithItemLineBinding;
import com.jack.recyclerviewstudy.decorationline.LeftAndRightTagDecoration;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.FakeData;

/**
 * https://www.jianshu.com/p/b46a4ff7c10a
 */
public class SimpleUseWithItemTagActivity extends BaseActivity implements ItemClickListener {
    ActivitySimpleUseWithItemLineBinding uiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_use_with_item_line);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        uiBinding.simpleUseRv.setLayoutManager(linearLayoutManager);

        uiBinding.simpleUseRv.addItemDecoration(new LeftAndRightTagDecoration(this));

        SimpleUseAdapter simpleUseAdapter = new SimpleUseAdapter(this, FakeData.items2, this);
        uiBinding.simpleUseRv.setAdapter(simpleUseAdapter);
    }

    @Override
    public void itemClick(int pos) {
        ToastUtils.showShort(FakeData.items2.get(pos).getData(), Toast.LENGTH_SHORT);
    }
}