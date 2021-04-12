package com.jack.recyclerviewstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jack.recyclerviewstudy.adapter.SimpleUseAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleUse(View view) {
        startActivity(new Intent(this, SimpleUseActivity.class));
    }

    public void simpleUseWithItemLine(View view) {
        startActivity(new Intent(this, SimpleUseWithItemLineActivity.class));
    }

    public void simpleUseWithItemTag(View view) {
        startActivity(new Intent(this, SimpleUseWithItemTagActivity.class));
    }

    public void simpleUseWithItemGroup(View view) {
        startActivity(new Intent(this, SimpleUseWithItemGroupActivity.class));
    }

    public void simpleUseWithItemGroup2(View view) {
        startActivity(new Intent(this, SimpleUseWithItemGroup2Activity.class));
    }

    public void simpleUseWithViewType(View view) {
        startActivity(new Intent(this, SimpleUseWithViewTypeActivity.class));
    }
}