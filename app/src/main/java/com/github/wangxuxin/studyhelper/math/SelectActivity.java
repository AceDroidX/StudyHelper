package com.github.wangxuxin.studyhelper.math;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.wangxuxin.studyhelper.R;

/**
 * Created by a1274 on 2016/8/21.
 */
public class SelectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */

    ////关卡添加部分////////////////////////////////////////////////////
    public void onePlusButton(View view){
        //startActivity(new Intent("com.github.wangxuxin.letscalculate.SelectActivity"));
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "onePlus");
        startActivity(intent);
    }

    public void twoPlusButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "twoPlus");
        startActivity(intent);
    }

    public void multiPlusButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "multiPlus");
        startActivity(intent);
    }

    public void oneLessButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "oneLess");
        startActivity(intent);
    }

    public void twoLessButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "twoLess");
        startActivity(intent);
    }

    public void multiLessButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "multiLess");
        startActivity(intent);
    }

    public void oneMultiplyButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "oneMultiply");
        startActivity(intent);
    }

    public void twoMultiplyButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "twoMultiply");
        startActivity(intent);
    }

    public void multiMultiplyButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "multiMultiply");
        startActivity(intent);
    }

    public void oneDivisionButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "oneDivision");
        startActivity(intent);
    }

    public void twoDivisionButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "twoDivision");
        startActivity(intent);
    }

    public void multiDivisionButton(View view){
        Intent intent = new Intent();
        intent.setClass(SelectActivity.this, LevelActivity.class);
        intent.putExtra("type", "multiDivision");
        startActivity(intent);
    }
    ////关卡添加部分////////////////////////////////////////////////////
}
