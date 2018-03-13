//package com.yklee.test.data;
//
//import android.databinding.ObservableField;
//import android.os.SystemClock;
//
///**
// * Created by yeonggyu.lee on 2018-03-07.
// */
//
//public class Calculate extends Thread {
//
//    private CalcModel calcModel = null;
//    private ObservableField<String> result = null;
//
//    public Calculate(CalcModel calcModel, ObservableField<String> result) {
//        this.calcModel = calcModel;
//        this.result = result;
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        SystemClock.sleep(1000);
//        result.set(String.valueOf(calcModel.getSt() * calcModel.getNd()));
//    }
//}
