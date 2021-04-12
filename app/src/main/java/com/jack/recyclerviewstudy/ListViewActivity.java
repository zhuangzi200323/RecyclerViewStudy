package com.jack.recyclerviewstudy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.jack.recyclerviewstudy.adapter.RecyAdapter;
import com.jack.recyclerviewstudy.databinding.ActivitySimpleUseBinding;
import com.jack.recyclerviewstudy.decorationline.DividerListItemDecoration;
import com.jack.recyclerviewstudy.model.FakeData;
import com.jack.recyclerviewstudy.recyevent.OnRecyclerItemClickListener;
import com.jack.recyclerviewstudy.recyevent.RecyItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ActivitySimpleUseBinding uiBinding;
    List<String> mStringList;
    RecyAdapter mRecyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple_use);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initRecy();
    }

    private void initRecy() {
        mRecyAdapter = new RecyAdapter(this,  FakeData.items2);

        uiBinding.simpleUseRv.setLayoutManager(new LinearLayoutManager(this));
        uiBinding.simpleUseRv.addItemDecoration(new DividerListItemDecoration(this, LinearLayoutManager.VERTICAL));
        uiBinding.simpleUseRv.setHasFixedSize(true);

        RecyItemTouchHelperCallback itemTouchHelperCallback = new RecyItemTouchHelperCallback(mRecyAdapter);
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
