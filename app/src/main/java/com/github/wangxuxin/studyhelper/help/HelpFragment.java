package com.github.wangxuxin.studyhelper.help;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.wangxuxin.studyhelper.BaseFragment;
import com.github.wangxuxin.studyhelper.R;
import com.github.wangxuxin.studyhelper.math.MathFragment;
import com.github.wangxuxin.studyhelper.math.SelectActivity;

/**
 * Created by a1274 on 2018/3/9.
 */

public class HelpFragment extends BaseFragment implements Parcelable {
    private static final String ARG_PARAM1 = "name";

    public static HelpFragment newInstance() {
        HelpFragment fragment = new HelpFragment();
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
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
