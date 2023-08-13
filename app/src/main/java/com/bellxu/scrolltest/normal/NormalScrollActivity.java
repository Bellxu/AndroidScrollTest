package com.bellxu.scrolltest.normal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bellxu.scrolltest.databinding.ActivityNormalScrollBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class NormalScrollActivity extends AppCompatActivity {

    private ActivityNormalScrollBinding normalScrollBinding;

    private DemoCollectionAdapter demoCollectionAdapter;

    private static final String[] tab_title = new String[]{"scrollTo/By", "Animator", "Layout"};

    public static void open(Activity activity) {
        activity.startActivity(new Intent(activity,NormalScrollActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        normalScrollBinding = ActivityNormalScrollBinding.inflate(getLayoutInflater());
        setContentView(normalScrollBinding.getRoot());
        normalScrollBinding.pager.setUserInputEnabled(false);
        demoCollectionAdapter = new DemoCollectionAdapter(this);
        normalScrollBinding.pager.setAdapter(demoCollectionAdapter);
        new TabLayoutMediator(normalScrollBinding.tabLayout, normalScrollBinding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tab_title[position]);
            }
        }).attach();
    }

    public static class DemoCollectionAdapter extends FragmentStateAdapter {

        public DemoCollectionAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new ScrollByAndToFragment();
                    break;
                case 1:
                    fragment = new AnimatorFragment();
                    break;
                case 2:
                    fragment = new LayoutScrollFragment();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 3;
        }


    }

    public void switchTab(int index) {
        normalScrollBinding.pager.setCurrentItem(index);
    }
}