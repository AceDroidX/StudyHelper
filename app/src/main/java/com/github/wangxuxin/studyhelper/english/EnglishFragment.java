package com.github.wangxuxin.studyhelper.english;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.wangxuxin.studyhelper.BaseFragment;
import com.github.wangxuxin.studyhelper.R;
import com.github.wangxuxin.studyhelper.math.MathFragment;
import com.github.wangxuxin.studyhelper.math.SelectActivity;


public class EnglishFragment extends BaseFragment implements Parcelable {
    private static final String ARG_PARAM1 = "name";

    public static EnglishFragment newInstance() {
        EnglishFragment fragment = new EnglishFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "");
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_english, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Button buttonE1 = getActivity().findViewById(R.id.buttonE1);
        Button buttonE2 = getActivity().findViewById(R.id.buttonE2);
        buttonE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),WordActivity.class);
                //intent.putExtra("name", "xiazdong");  //放入数据
                startActivity(intent);  //开始跳转
            }
        });
        buttonE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplication(),"正在开发中_(:3 」∠ )_",Toast.LENGTH_LONG).show();
            }
        });
    }
}
