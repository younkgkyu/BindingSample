package com.yklee.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.yklee.test.R;
import com.yklee.test.data.UserData;

import java.util.ArrayList;

/**
 * Created by yeonggyu.lee on 2017-05-15.
 */

public class MainAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private ArrayList<UserData> mDataList = null;

    public MainAdapter(ArrayList<UserData> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        UserData data = mDataList.get(position);
        holder.itemDataBinding.setUser(data);

    }
}