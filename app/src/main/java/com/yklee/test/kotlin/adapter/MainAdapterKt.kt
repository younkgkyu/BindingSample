package com.yklee.test.kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.yklee.test.R
import com.yklee.test.kotlin.data.UserDataKt

/**
 * Created by yeonggyu.lee on 2018-03-12.
 */
class MainAdapterKt: RecyclerView.Adapter<ListViewHolderKt> {

    private var mContext: Context
    private var dataList: ArrayList<UserDataKt>

    constructor(context: Context, dataList: ArrayList<UserDataKt>) {
        this.mContext = context
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolderKt {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.item_main_list, parent, false)
        return ListViewHolderKt(itemView)
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    override fun onBindViewHolder(holder: ListViewHolderKt, position: Int) {
        holder.dataBinding.user = this.dataList[position]
    }
}