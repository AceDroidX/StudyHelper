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

public class WordActivity extends AppCompatActivity {
    String[][] wordarray = new String[100][100];
    JSONObject jsonobject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWord();
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

    private void initWord() {
        try {
            String read = readString(getApplicationContext());
            jsonobject = new JSONObject(read);
            Log.d("wxxDebug", jsonobject.toString());
            String replaced = read.replace("{", "").replace("}", "").replace("\"", "");
            String[] temparray = replaced.split(",");
            for(int i=0;i<temparray.length;i++){
                wordarray[i] = temparray[i].split(":");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static String readString(Context context) {
        InputStream is = null;
        String msg = null;
        try {
            is = context.getResources().getAssets().open("y.json");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            msg = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }
}
