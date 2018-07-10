//package com.yklee.test.viewmodel;
//
//import android.content.Context;
//import android.databinding.ObservableField;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;
//import android.text.Editable;
//import android.widget.Toast;
//
//import com.yklee.test.Util.Utils;
//import com.yklee.test.data.CalcModel;
//import com.yklee.test.data.Calculate;
//
///**
// * Created by yeonggyu.lee on 2018-03-07.
// */
//
//public class MainViewModel implements IBaseViewModel {
//
//    private Context mContext;
//    public ObservableField<String> mResult = new ObservableField<>();
//    private CalcModel calcModel = new CalcModel();
//
//    public MainViewModel(Context context) {
//        this.mContext = context;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//
//    }
//
//    @Override
//    public void onResume() {
//
//    }
//
//    @Override
//    public void onPause() {
//
//    }
//
//    @Override
//    public void onDestory() {
//
//    }
//
//    public void afterTextChangedst(Editable s) {
//        int first = Utils.isEmpty(s.toString()) ? 0 : Integer.valueOf(s.toString());
//        calcModel.setSt(first);
//        new Calculate(calcModel, mResult).start();
//    }
//
//    public void afterTextChangednd(Editable s) {
//        int second = Utils.isEmpty(s.toString()) ? 0 : Integer.valueOf(s.toString());
//        calcModel.setNd(second);
//        new Calculate(calcModel, mResult).start();
//    }
//
////    public void afterTextChangedst(int st) {
////        calcModel.setSt(st);
////        new Calculate(calcModel, mResult).start();
////    }
////
////    public void afterTextChangednd(int nd) {
////        calcModel.setNd(nd);
////        new Calculate(calcModel, mResult).start();
////    }
//
//    public void MoveListBindingActivity() {
//        Toast.makeText(mContext, "MoveListBindingActivity", Toast.LENGTH_SHORT).show();
//    }
//
//    public void onClickfab(FloatingActionButton view) {
//        Toast.makeText(view.getContext(), "onClickfab", Toast.LENGTH_SHORT).show();
//    }
//}
