package com.github.wangxuxin.studyhelper.english;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;

import com.github.wangxuxin.studyhelper.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.wangxuxin.studyhelper.english.WordBuilder.readString;

public class WordActivity extends AppCompatActivity {
    String[][] wordarray = new String[100][100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WordBuilder wordBuilder=new WordBuilder(getApplicationContext());
        wordarray=wordBuilder.initWord();
        GridLayout gridLayout = findViewById(R.id.wordGrid);
        for(int i=0;i<wordarray.length;i++){
            TextView textView1 = new TextView(this);
            textView1.setText(wordarray[i][0]);
            textView1.setWidth(200);
            TextView textView2 = new TextView(this);
            textView2.setText(wordarray[i][1]);
            gridLayout.addView(textView1);
            gridLayout.addView(textView2);
        }
    }
}
