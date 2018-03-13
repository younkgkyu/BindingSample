package com.yklee.test.kotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yklee.test.R
import com.yklee.test.databinding.ActivityMainBinding
import com.yklee.test.kotlin.viewmodel.MainViewModelKt

/**
 * Created by yeonggyu.lee on 2018-03-08.
 */
class MainActivityKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dataBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.mainViewModel = MainViewModelKt()
        initialize(dataBinding)
    }

    private fun initialize(dataBinding: ActivityMainBinding) {
        setSupportActionBar(dataBinding.toolbar)
    }
}