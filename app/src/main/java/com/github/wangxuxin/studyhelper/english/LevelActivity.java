package com.github.wangxuxin.studyhelper.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.github.wangxuxin.studyhelper.R;
import com.github.wangxuxin.studyhelper.math.NumberBuilder;
/**
* 正在开发中
* 180313 by AceDroidX
*
* */
public class LevelActivity extends AppCompatActivity {
    public static int one;
    public static int two;
    public static int answer;
    public static String symbol;
    public String type;
    public int grade=0;
    public int end=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_exam);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();    //获得当前的Intent
        Bundle bundle = intent.getExtras();  //获得全部数据
        String value = bundle.getString("type");  //获得名为name的值
        type=value;

        TextView textView=(TextView)findViewById(R.id.typeText1);
        Log.d("wxxDebug",value);

        onLevel();
    }

    void onLevel() {
        Log.d("wxxDebug","onLevel");
        final TextView gradeText = (TextView) findViewById(R.id.gradeText1);
        final TextView subjectText=(TextView)findViewById(R.id.subjectText1);

        gradeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(grade>end){
                    if(!getResources().getText(R.string.finishLevel).equals(subjectText.getText())){
                        finishLevel();
                    }
                    return;
                }
                NumberBuilder.numberBuilder(type);
                Log.d("wxx",type);
                Log.d("wxxDebug1",""+ com.github.wangxuxin.studyhelper.math.LevelActivity.one);
                Log.d("wxxDebug1",""+ com.github.wangxuxin.studyhelper.math.LevelActivity.two);
                Log.d("wxxDebug1",""+ com.github.wangxuxin.studyhelper.math.LevelActivity.answer);
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
        final TextView gradeText = (TextView) findViewById(R.id.gradeText1);
        gradeText.setText((grade-1)+"/"+end);
    }
}
