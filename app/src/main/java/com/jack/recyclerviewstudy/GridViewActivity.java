package com.jack.recyclerviewstudy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.jack.recyclerviewstudy.adapter.RecyAdapter;
import com.jack.recyclerviewstudy.databinding.ActivitySimpleUseBinding;
import com.jack.recyclerviewstudy.decorationline.DividerGridItemDecoration;
import com.jack.recyclerviewstudy.model.FakeData;
import com.jack.recyclerviewstudy.recyevent.OnRecyclerItemClickListener;
import com.jack.recyclerviewstudy.recyevent.RecyItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    ActivitySimpleUseBinding uiBinding;
    RecyAdapter mRecyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_use);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initRecy();
    }

    private void initRecy() {
        mRecyAdapter = new RecyAdapter(this, FakeData.items2);

        uiBinding.simpleUseRv.setLayoutManager(new GridLayoutManager(this, 4));
        uiBinding.simpleUseRv.addItemDecoration(new DividerGridItemDecoration(this));
        uiBinding.simpleUseRv.setHasFixedSize(true);

        RecyItemTouchHelperCallback itemTouchHelperCallback = new RecyItemTouchHelperCallback(mRecyAdapter, false, true);
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(uiBinding.simpleUseRv);

        uiBinding.simpleUseRv.addOnItemTouchListener(new OnRecyclerItemClickListener(uiBinding.simpleUseRv) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                RecyAdapter.ViewHolder viewHolder1 = (RecyAdapter.ViewHolder) viewHolder;
                String tvString = viewHolder1.getBinding().titleTv.getText().toString();
                ToastUtils.showShort(tvString, Toast.LENGTH_SHORT);
            }

            @Override
            public void onLongClick(RecyclerView.ViewHolder viewHolder) {
                RecyAdapter.ViewHolder viewHolder1 = (RecyAdapter.ViewHolder) viewHolder;
                String tvString = viewHolder1.getBinding().titleTv.getText().toString();
                ToastUtils.showShort(tvString, Toast.LENGTH_SHORT);
                if (viewHolder.getLayoutPosition() != 0) {
                    itemTouchHelper.startDrag(viewHolder);
                }
            }
        });
        uiBinding.simpleUseRv.setAdapter(mRecyAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
