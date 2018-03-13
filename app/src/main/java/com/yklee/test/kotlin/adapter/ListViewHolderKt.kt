package com.yklee.test.kotlin.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.yklee.test.databinding.ItemMainListBinding

/**
 * Created by yeonggyu.lee on 2018-03-12.
 */
class ListViewHolderKt: RecyclerView.ViewHolder {

    var dataBinding: ItemMainListBinding

    constructor(itemView: View) : super(itemView) {
        dataBinding = DataBindingUtil.bind(itemView)
    }

}