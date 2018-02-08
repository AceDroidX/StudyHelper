package com.github.wangxuxin.studyhelper.math;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.github.wangxuxin.studyhelper.R;

/**
 * Created by a1274 on 2016/8/21.
 */
public class LevelActivity extends AppCompatActivity {
    public static int one;
    public static int two;
    public static int answer;
    public static String symbol;
    public String type;
    public int grade=0;
    public int end=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();    //获得当前的Intent
        Bundle bundle = intent.getExtras();  //获得全部数据
        String value = bundle.getString("type");  //获得名为name的值
        type=value;

        TextView textView=(TextView)findViewById(R.id.typeText1);
        Log.d("wxxDebug",value);

        switch (value){
            ////关卡添加部分////////////////////////////////////////////////////
            case "onePlus":
                textView.setText(getResources().getText(R.string.onePlus));
                break;
            case "twoPlus":
                textView.setText(getResources().getText(R.string.twoPlus));
                break;
            case "multiPlus":
                textView.setText(getResources().getText(R.string.multiPlus));
                break;
            case "oneLess":
                textView.setText(getResources().getText(R.string.oneLess));
                break;
            case "twoLess":
                textView.setText(getResources().getText(R.string.twoLess));
                break;
            case "multiLess":
                textView.setText(getResources().getText(R.string.multiLess));
                break;
            case "oneMultiply":
                textView.setText(getResources().getText(R.string.oneMultiply));
                break;
            case "twoMultiply":
                textView.setText(getResources().getText(R.string.twoMultiply));
                break;
            case "multiMultiply":
                textView.setText(getResources().getText(R.string.multiMultiply));
                break;
            case "oneDivision":
                textView.setText(getResources().getText(R.string.oneDivision));
                break;
            case "twoDivision":
                textView.setText(getResources().getText(R.string.twoDivision));
                break;
            case "multiDivision":
                textView.setText(getResources().getText(R.string.multiDivision));
                break;
            ////关卡添加部分////////////////////////////////////////////////////
            default:
                return;
        }
        onLevel();
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

    void onLevel() {
        Log.d("wxxDebug","onLevel");
        final TextView gradeText = (TextView) findViewById(R.id.gradeText1);

        gradeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(grade>end){
                    finishLevel();
                    return;
                }
                NumberBuilder.numberBuilder(type);
                Log.d("wxx",type);
                Log.d("wxxDebug1",""+LevelActivity.one);
                Log.d("wxxDebug1",""+LevelActivity.two);
                Log.d("wxxDebug1",""+LevelActivity.answer);
                TextView subjectText = (TextView) findViewById(R.id.subjectText1);
                subjectText.setText(one + symbol + two);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Log.d("wxxDebug",""+grade);
        Log.d("wxxDebug",""+end);
        gradeText.setText(grade+"/"+end);

        final EditText answerEdit = (EditText) findViewById(R.id.answerEdit);
        answerEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("wxxDebug2",answerEdit.getText().toString());
                if(grade>end){
                    return;
                }
                if (answerEdit.getText().toString().equals(""+answer)) {
                    grade++;
                    gradeText.setText(grade+"/"+end);
                    answerEdit.setText("");
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    void finishLevel(){
        TextView subjectText=(TextView)findViewById(R.id.subjectText1);
        subjectText.setText(getResources().getText(R.string.finishLevel));
    }
}
