package com.yklee.test.kotlin.data

/**
 * Created by yeonggyu.lee on 2018-03-09.
 */
data class CalcModelKt (var firstValue: Int = 0, var secondValue: Int = 0) {
    fun getPlus(): Int {
        return firstValue + secondValue
    }
}