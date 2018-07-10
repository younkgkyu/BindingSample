package com.yklee.test.kotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.yklee.test.R
import com.yklee.test.databinding.ActivityListBinding
import com.yklee.test.kotlin.adapter.MainAdapterKt
import com.yklee.test.kotlin.data.UserDataKt

/**
 * Created by yeonggyu.lee on 2018-03-12.
 */
class ListBindingActivityKt: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dataBinding: ActivityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        initialize(dataBinding)
    }

    private fun initialize(dataBinding: ActivityListBinding) {
        var arrayList: ArrayList<UserDataKt> = ArrayList()
        arrayList.add(UserDataKt("lee", "21"))
        arrayList.add(UserDataKt("lee", "22"))
        arrayList.add(UserDataKt("lee", "23"))
        arrayList.add(UserDataKt("lee", "24"))
        arrayList.add(UserDataKt("lee", "25"))

        dataBinding.rvMain.layoutManager = LinearLayoutManager(this)
        dataBinding.rvMain.adapter = MainAdapterKt(this, arrayList)
    }

}