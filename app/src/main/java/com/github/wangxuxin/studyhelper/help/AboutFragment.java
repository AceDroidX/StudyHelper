package com.github.wangxuxin.studyhelper.help;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.wangxuxin.studyhelper.BaseFragment;
import com.github.wangxuxin.studyhelper.MainFragment;
import com.github.wangxuxin.studyhelper.R;
import com.github.wangxuxin.studyhelper.math.MathFragment;

/**
 * Created by a1274 on 2018/2/4.
 */

public class AboutFragment extends BaseFragment implements Parcelable {
    private static final String ARG_PARAM1 = "name";

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
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
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onResume(){
        super.onResume();
        TextView versionText=getView().findViewById(R.id.textView_version);
        try {
            versionText.setText("V"+getVersionName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView copyrightText = getView().findViewById(R.id.textView_copyright);
        if(!copyrightText.getText().equals("By wxx")){
            copyrightText.setText("By wxx");
            Log.d("wxxDebugAbout","原程序已被修改！！！！By wxx");
        }

        TextView websiteText = getView().findViewById(R.id.textView_website);
        websiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://wangxuxin.github.io"; // web address
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getActivity().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getActivity().getPackageName(),0);
        Log.d("wxxDebugAbout",packInfo.versionName);
        return packInfo.versionName;
    }
}
