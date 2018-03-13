package com.yklee.test.kotlin.viewmodel

import android.os.Bundle

/**
 * Created by yeonggyu.lee on 2018-03-09.
 */
interface IBaseViewModelKt {
    fun onCreate(savedInstanceState: Bundle?)
    fun onResume()
    fun onPause()
    fun onDestory()
}