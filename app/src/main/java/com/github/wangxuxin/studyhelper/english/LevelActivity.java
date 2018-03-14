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

import java.util.Arrays;

/**
 * 180313 by AceDroidX
 */
public class LevelActivity extends AppCompatActivity {
    String[] word;
    String answer;
    int grade = 0;
    int end = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_exam);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        onLevel();
    }

    void onLevel() {
        Log.d("wxxDebug", "onLevel");
        final TextView gradeText = findViewById(R.id.gradeText1);
        final TextView subjectText = findViewById(R.id.subjectText1);
        final WordBuilder wordBuilder = new WordBuilder(getApplication());

        gradeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (grade > end) {
                    if (!getResources().getText(R.string.finishLevel).equals(subjectText.getText())) {
                        finishLevel();
                    }
                    return;
                }
                word = wordBuilder.create();
                Log.d("wxxDebug", Arrays.toString(word));
                answer = word[0];
                Log.d("wxxDebug", "Answer:" + answer);
                TextView subjectText = (TextView) findViewById(R.id.subjectText1);
                subjectText.setText(word[1]);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        gradeText.setText(grade + "/" + end);

        final EditText answerEdit = findViewById(R.id.answerEdit);
        answerEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("wxxDebug","Change:"+answerEdit.getText().toString());
                if (grade > end) {
                    return;
                }
                if (answerEdit.getText().toString().equals(answer)) {
                    grade++;
                    gradeText.setText(grade + "/" + end);
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

    void finishLevel() {
        TextView subjectText = findViewById(R.id.subjectText1);
        subjectText.setText(getResources().getText(R.string.finishLevel));
        final TextView gradeText = (TextView) findViewById(R.id.gradeText1);
        gradeText.setText((grade - 1) + "/" + end);
    }
}
