package com.yklee.test.kotlin.viewmodel

import android.content.Intent
import android.databinding.ObservableField
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.yklee.test.kotlin.ListBindingActivityKt
import com.yklee.test.kotlin.Utils.StringUtil
import com.yklee.test.kotlin.data.CalcModelKt
import com.yklee.test.kotlin.module.CalculateKt

/**
 * Created by yeonggyu.lee on 2018-03-09.
 */
class MainViewModelKt: IBaseViewModelKt {

    private var mCalcModelKt: CalcModelKt = CalcModelKt()
    var mResult: ObservableField<String> = ObservableField()

    override fun onCreate(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun moveListBindingActivity(view: View) {
//        Toast.makeText(view.context, "MoveListBindingActivity", Toast.LENGTH_SHORT).show()
        view.context.startActivity(Intent(view.context, ListBindingActivityKt::class.java))
    }

    fun onClickfab(view: FloatingActionButton) {
        Toast.makeText(view.context, "onClickfab", Toast.LENGTH_SHORT).show()
    }

    fun afterTextChangedst(edit: Editable) {
        mCalcModelKt.firstValue = if (StringUtil.isEmpty(edit.toString())) 0 else edit.toString().toInt()
        var calculateKt = CalculateKt(mCalcModelKt, mResult)
        calculateKt.start()
    }

    fun afterTextChangednd(edit: Editable) {
        mCalcModelKt.secondValue = if (StringUtil.isEmpty(edit.toString())) 0 else edit.toString().toInt()
        var calculateKt = CalculateKt(mCalcModelKt, mResult)
        calculateKt.start()
    }
}