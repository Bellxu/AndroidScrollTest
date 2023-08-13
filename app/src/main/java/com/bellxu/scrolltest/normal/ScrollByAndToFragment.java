package com.bellxu.scrolltest.normal;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bellxu.scrolltest.databinding.FragmentScrollByAndToBinding;

public class ScrollByAndToFragment extends Fragment {

    private  FragmentScrollByAndToBinding mViewBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentScrollByAndToBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.buttonScrollTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绝对坐标 scroll的是draw的内容
                mViewBinding.scrollView.scrollTo(0,-50);
//                mViewBinding.scrollView.scrollBy(100,0);
//                ObjectAnimator.ofFloat(mViewBinding.scrollView,"translationX",0,100).setDuration(100).start();
            }
        });
        mViewBinding.buttonScrollBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //相对坐标
                mViewBinding.scrollView.scrollBy(0,-50);
//                mViewBinding.scrollView.scrollBy(100,0);
//                ObjectAnimator.ofFloat(mViewBinding.scrollView,"translationX",0,100).setDuration(100).start();
            }
        });
    }
}
