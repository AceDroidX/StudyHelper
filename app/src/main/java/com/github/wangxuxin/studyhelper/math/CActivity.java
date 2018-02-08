package com.github.wangxuxin.studyhelper.math;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.wangxuxin.studyhelper.R;

public class CActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    public void onExitButton(View view){
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void onStartButton(View view){
        //startActivity(new Intent("com.github.wangxuxin.letscalculate.SelectActivity"));
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SelectActivity.class);  //从IntentActivity跳转到SubActivity
        //intent.putExtra("name", "xiazdong");  //放入数据
        startActivity(intent);  //开始跳转
    }

    public void onAboutButton(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AboutActivity.class);  //从IntentActivity跳转到SubActivity
        //intent.putExtra("name", "xiazdong");  //放入数据
        startActivity(intent);  //开始跳转
    }
    */
}
