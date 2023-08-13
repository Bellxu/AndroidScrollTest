package com.bellxu.scrolltest.normal;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bellxu.scrolltest.databinding.FragmentAnimatorBinding;
import com.bellxu.scrolltest.databinding.FragmentScrollByAndToBinding;

public class AnimatorFragment extends Fragment {

    private  FragmentAnimatorBinding mViewBinding;

    private int scroll = 0;


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
                ObjectAnimator.ofFloat(mViewBinding.scrollView,"translationX",scroll,scroll+=100).setDuration(100).start();
            }
        });
    }
}
