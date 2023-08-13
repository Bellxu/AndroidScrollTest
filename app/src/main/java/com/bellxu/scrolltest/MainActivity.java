package com.bellxu.scrolltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bellxu.scrolltest.databinding.ActivityMainBinding;
import com.bellxu.scrolltest.normal.NormalScrollActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initClick();
    }

    private void initClick() {
        binding.normalScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalScrollActivity.open(MainActivity.this);
            }
        });
        binding.smoothScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalScrollActivity.open(MainActivity.this);
            }
        });
    }
}