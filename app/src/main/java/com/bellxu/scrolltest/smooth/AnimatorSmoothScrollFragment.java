package com.bellxu.scrolltest.smooth;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bellxu.scrolltest.databinding.FragmentAnimatorBinding;

public class AnimatorSmoothScrollFragment extends Fragment {

    private  FragmentAnimatorBinding mViewBinding;

    private int scroll = 0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentAnimatorBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    final int startX=0;
    final int deltaX=-100;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.buttonScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ObjectAnimator.ofFloat(mViewBinding.scrollView,"translationX",scroll,scroll+=100).setDuration(1000).start();
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 1).setDuration(1000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                        float animatedFraction = animation.getAnimatedFraction();

                        int i = (int) (deltaX * animatedFraction);
                        Log.i("ttt", "scrollX= "+mViewBinding.scrollView.getScrollX());
                        mViewBinding.scrollView.scrollTo(startX+ i,0);
                    }
                });
                valueAnimator.start();
            }
        });
    }


}
