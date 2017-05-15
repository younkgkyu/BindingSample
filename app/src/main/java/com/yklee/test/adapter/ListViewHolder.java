package com.yklee.test.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yklee.test.databinding.ItemMainListBinding;

/**
 * Created by yeonggyu.lee on 2017-05-15.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    public ItemMainListBinding itemDataBinding;

    public ListViewHolder(View itemView) {
        super(itemView);
        itemDataBinding = DataBindingUtil.bind(itemView);
    }
}