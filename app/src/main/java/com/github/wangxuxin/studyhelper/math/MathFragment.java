package com.github.wangxuxin.studyhelper.math;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.wangxuxin.studyhelper.BaseFragment;
import com.github.wangxuxin.studyhelper.MainActivity;
import com.github.wangxuxin.studyhelper.MainFragment;
import com.github.wangxuxin.studyhelper.R;

/**
 * Created by a1274 on 2018/2/3.
 */

public class MathFragment extends BaseFragment implements Parcelable {
    private static final String ARG_PARAM1 = "name";

    public static MathFragment newInstance() {
        MathFragment fragment = new MathFragment();
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
        return inflater.inflate(R.layout.fragment_math, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Button buttonFormula = getActivity().findViewById(R.id.buttonFormula);
        Button buttonExam = getActivity().findViewById(R.id.buttonExam);
        buttonFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttonExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),SelectActivity.class);
                //intent.putExtra("name", "xiazdong");  //放入数据
                startActivity(intent);  //开始跳转
            }
        });
    }
}
