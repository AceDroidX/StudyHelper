package com.github.wangxuxin.studyhelper.english;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by AceDroidX on 2018/3/14 22:22 ~ 23:55.
 * <p>
 * 已知问题：create时无法判断单词数最大数量与题目要求数量，导致无限循环
 */

class WordBuilder {
    private Context context;
    private String[][] wordarray = new String[100][100];
    private int[] createdWord = new int[100];//已输出过的单词编号
    private int wordid = 0;
    private int wordMax;

    WordBuilder(Context context) {
        this.context = context;
        initWord();
    }

    String[] create() {
        boolean issame = false;
        Random rand = new Random();
        //int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        int randNumber = rand.nextInt(wordMax);
        for (int i : createdWord) {
            if (i == randNumber) {
                issame = true;
                break;
            }
        }
        if (issame) {
            return create();
        } else {
            createdWord[wordid] = randNumber;
            //Log.d("wxxDebug",randNumber+"");
            //Log.d("wxxDebug",wordid+"");
            //Log.d("wxxDebug", Arrays.toString(createdWord));
            wordid++;
            return wordarray[randNumber];
        }
    }

    String[][] initWord() {
        try {
            String read = readString(context);
            JSONObject jsonobject = new JSONObject(read);
            Log.d("wxxDebug", jsonobject.toString());
            String replaced = read.replace("{", "").replace("}", "").replace("\"", "");
            String[] temparray = replaced.split(",");
            wordMax = temparray.length;
            for (int i = 0; i < temparray.length; i++) {
                wordarray[i] = temparray[i].split(":");
            }
            return wordarray;
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "initWord错误！！！", Toast.LENGTH_LONG).show();
            return wordarray;
        }

    }

    static String readString(Context context) {
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
