package com.github.wangxuxin.studyhelper.math;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.wangxuxin.studyhelper.BaseFragment;
import com.github.wangxuxin.studyhelper.MainFragment;
import com.github.wangxuxin.studyhelper.R;

/**
 * Created by a1274 on 2018/2/3.
 */

public class MathFragment extends BaseFragment {
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
}
