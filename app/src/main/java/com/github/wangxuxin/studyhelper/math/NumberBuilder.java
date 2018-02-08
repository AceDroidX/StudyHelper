package com.github.wangxuxin.studyhelper.math;

import java.util.Random;

/**
 * Created by a1274 on 2016/8/22.
 */
public class NumberBuilder {
    public static void numberBuilder(String type){
        switch (type){
            case "onePlus":
                onePlus();
                break;
            case "twoPlus":
                twoPlus();
                break;
            case "multiPlus":
                multiPlus();
                break;
            case "oneLess":
                oneLess();
                break;
            case "twoLess":
                twoLess();
                break;
            case "multiLess":
                multiLess();
                break;
            case "oneMultiply":
                oneMultiply();
                break;
            case "twoMultiply":
                twoMultiply();
                break;
            case "multiMultiply":
                multiMultiply();
                break;
            case "oneDivision":
                oneDivision();
                break;
            case "twoDivision":
                twoDivision();
                break;
            case "multiDivision":
                multiDivision();
                break;
            default:
                return;
        }
    }

    static void onePlus(){
        //new Random().nextInt(max - min + 1) + min
        //包括max和min
        LevelActivity.one = new Random().nextInt(9 + 1);
        LevelActivity.two = new Random().nextInt(9 + 1);
        LevelActivity.symbol="+";
        LevelActivity.answer=LevelActivity.one+LevelActivity.two;
    }

    static void twoPlus(){
        LevelActivity.one = new Random().nextInt(99 + 1);
        LevelActivity.two = new Random().nextInt(99 + 1);
        LevelActivity.symbol="+";
        LevelActivity.answer=LevelActivity.one+LevelActivity.two;
    }

    static void multiPlus(){
        LevelActivity.one = new Random().nextInt(1000 + 1);
        LevelActivity.two = new Random().nextInt(1000 + 1);
        LevelActivity.symbol="+";
        LevelActivity.answer=LevelActivity.one+LevelActivity.two;
    }

    static void oneLess(){
        int one=new Random().nextInt(9 + 1);
        int two=new Random().nextInt(9 + 1);
        LevelActivity.symbol="-";
        LevelActivity.one = Math.max(one, two);
        LevelActivity.two = Math.min(one, two);
        LevelActivity.answer=LevelActivity.one-LevelActivity.two;
    }

    static void twoLess(){
        int one=new Random().nextInt(99 + 1);
        int two=new Random().nextInt(99 + 1);
        LevelActivity.symbol="-";
        LevelActivity.one = Math.max(one, two);
        LevelActivity.two = Math.min(one, two);
        LevelActivity.answer=LevelActivity.one-LevelActivity.two;
    }

    static void multiLess(){
        int one=new Random().nextInt(1000 + 1);
        int two=new Random().nextInt(1000 + 1);
        LevelActivity.symbol="-";
        LevelActivity.one = Math.max(one, two);
        LevelActivity.two = Math.min(one, two);
        LevelActivity.answer=LevelActivity.one-LevelActivity.two;
    }

    static void oneMultiply(){
        LevelActivity.one=new Random().nextInt(9 + 1);
        LevelActivity.two=new Random().nextInt(9 + 1);
        LevelActivity.symbol="×";
        LevelActivity.answer=LevelActivity.one*LevelActivity.two;
    }

    static void twoMultiply(){
        LevelActivity.one=new Random().nextInt(99 + 1);
        LevelActivity.two=new Random().nextInt(99 + 1);
        LevelActivity.symbol="×";
        LevelActivity.answer=LevelActivity.one*LevelActivity.two;
    }

    static void multiMultiply() {
        LevelActivity.one = new Random().nextInt(1000 + 1);
        LevelActivity.two = new Random().nextInt(1000 + 1);
        LevelActivity.symbol = "×";
        LevelActivity.answer = LevelActivity.one * LevelActivity.two;
    }

    static void oneDivision() {
        int one = new Random().nextInt(9 - 1 + 1) + 1;
        int two = new Random().nextInt(9 - 1 + 1) + 1;
        int answer = one * two;
        LevelActivity.symbol = "÷";
        LevelActivity.one = answer;
        LevelActivity.two = one;
        LevelActivity.answer = two;
    }

    static void twoDivision() {
        int one = new Random().nextInt(99 - 1 + 1) + 1;
        int two = new Random().nextInt(99 - 1 + 1) + 1;
        int answer = one * two;
        LevelActivity.symbol = "÷";
        LevelActivity.one = answer;
        LevelActivity.two = one;
        LevelActivity.answer = two;
    }

    static void multiDivision() {
        int one = new Random().nextInt(1000 - 1 + 1) + 1;
        int two = new Random().nextInt(1000 - 1 + 1) + 1;
        int answer = one * two;
        LevelActivity.symbol = "÷";
        LevelActivity.one = answer;
        LevelActivity.two = one;
        LevelActivity.answer = two;
    }
}
