//package com.yklee.test.activity;
//
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import com.yklee.test.R;
//import com.yklee.test.adapter.MainAdapter;
//import com.yklee.test.data.UserData;
//import com.yklee.test.databinding.ActivityListBinding;
//
//import java.util.ArrayList;
///**
// * Created by yeonggyu.lee on 2017-04-26.
// */
//
//public class ListBindingActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ActivityListBinding binding = DataBindingUtil.setContentView(ListBindingActivity.this, R.layout.activity_list);
//
//        initialize(binding);
//    }
//
//    private void initialize(final ActivityListBinding dataBinding) {
//
//        ArrayList<UserData> dataList = new ArrayList<>();
//        UserData data = (UserData) getIntent().getSerializableExtra("userData");
//        dataList.add(data);
//
//        LinearLayoutManager llManager = new LinearLayoutManager(ListBindingActivity.this);
//        dataBinding.rvMain.setLayoutManager(llManager);
//        dataBinding.rvMain.setAdapter(new MainAdapter(dataList));
//    }
//}
