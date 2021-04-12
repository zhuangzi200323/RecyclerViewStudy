package com.jack.recyclerviewstudy;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.ToastUtils;
import com.jack.recyclerviewstudy.adapter.SimpleUseAdapter;
import com.jack.recyclerviewstudy.databinding.ActivitySimpleUseBinding;
import com.jack.recyclerviewstudy.listener.ItemClickListener;
import com.jack.recyclerviewstudy.model.FakeData;

public class SimpleUseGridLayoutActivity extends BaseActivity implements ItemClickListener {
    String TAG = SimpleUseGridLayoutActivity.class.getSimpleName();
    ActivitySimpleUseBinding uiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_use);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        uiBinding.simpleUseRv.setLayoutManager(gridLayoutManager);

        SimpleUseAdapter simpleUseAdapter = new SimpleUseAdapter(this, FakeData.items2, this);
        uiBinding.simpleUseRv.setAdapter(simpleUseAdapter);
    }

    @Override
    public void itemClick(int pos) {
        Log.e(TAG, "##### pos " + pos);
        //Toast.makeText(this, FakeData.items2.get(pos).getData(), Toast.LENGTH_SHORT).show();
        ToastUtils.showShort(FakeData.items2.get(pos).getData(), Toast.LENGTH_SHORT);
    }
}