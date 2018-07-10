package com.yklee.test.kotlin.module

import android.databinding.Observable
import android.databinding.ObservableField
import android.os.SystemClock
import com.yklee.test.kotlin.data.CalcModelKt

const val TAG = "CalculateKt.kt"

/**
 * Created by yeonggyu.lee on 2018-03-09.
 */
class CalculateKt: Thread {

    var calcModel: CalcModelKt
    var observableField: ObservableField<String>

    constructor(calcModel: CalcModelKt, observableField: ObservableField<String>) {
        this.calcModel = calcModel
        this.observableField = observableField
    }

    override fun run() {
        super.run()
        SystemClock.sleep(1000)
        observableField.set("${calcModel.getPlus()}")
    }

}