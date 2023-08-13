package com.bellxu.scrolltest.normal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bellxu.scrolltest.databinding.FragmentAnimatorBinding;

public class LayoutScrollFragment extends Fragment {

    private FragmentAnimatorBinding mViewBinding;
    private int scroll = 100;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentAnimatorBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.buttonScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mViewBinding.scrollView.getLayoutParams();
                layoutParams.topMargin+=100;
                mViewBinding.scrollView.requestLayout();
//                ObjectAnimator.ofFloat(mViewBinding.scrollView,"translationX",0,100).setDuration(100).start();
            }
        });
    }
}
