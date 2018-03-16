package com.example.selectanddelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

import com.example.selectanddelete.fragment.HomeFragment;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().
                beginTransaction().
                    add(R.id.content_container,
                        HomeFragment.newInstance(0)).commit();

    }


}
