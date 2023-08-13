package com.bellxu.scrolltest.smooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import android.os.Bundle;

import com.bellxu.scrolltest.databinding.ActivitySmoothScrollBinding;
import com.bellxu.scrolltest.normal.AnimatorFragment;
import com.bellxu.scrolltest.normal.LayoutScrollFragment;
import com.bellxu.scrolltest.normal.NormalScrollActivity;
import com.bellxu.scrolltest.normal.ScrollByAndToFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SmoothScrollActivity extends AppCompatActivity {


    
    ActivitySmoothScrollBinding smoothScrollBinding;
    private DemoCollectionAdapter demoCollectionAdapter;

    private static final String[] tab_title = new String[]{"scrollTo/By", "Animator", "Layout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smoothScrollBinding = ActivitySmoothScrollBinding.inflate(getLayoutInflater());
        setContentView(smoothScrollBinding.getRoot());
        smoothScrollBinding.pager.setUserInputEnabled(false);
        demoCollectionAdapter = new DemoCollectionAdapter(this);
        smoothScrollBinding.pager.setAdapter(demoCollectionAdapter);
        new TabLayoutMediator(smoothScrollBinding.tabLayout, smoothScrollBinding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
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
        smoothScrollBinding.pager.setCurrentItem(index);
    }
}