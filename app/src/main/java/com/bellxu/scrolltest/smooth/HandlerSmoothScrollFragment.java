package com.bellxu.scrolltest.smooth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bellxu.scrolltest.databinding.FragmentScrollerBinding;

public class HandlerSmoothScrollFragment extends Fragment {
    private static final int MESSAGE=1;
    private static final int FRAME_COUNT=30;
    private static final int DELAYED_TIME=33;


    private FragmentScrollerBinding mViewBinding;
    private int mCount=0;
    @SuppressLint("HandlerLeak")
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MESSAGE:
                    mCount++;
                    if (mCount<FRAME_COUNT) {
                        float f = (float) mCount / FRAME_COUNT;
                        int scrollX = (int) (f*100);
                        mViewBinding.scrollView.scrollTo(scrollX,0);
                        mHandler.sendEmptyMessageDelayed(MESSAGE,DELAYED_TIME);
                    }
                    break;
            }
        }
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentScrollerBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.buttonScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(MESSAGE);
            }
        });
    }


}
