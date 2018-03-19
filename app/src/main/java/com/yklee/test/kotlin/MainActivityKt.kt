package com.yklee.test.kotlin

import android.databinding.DataBindingUtil
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yklee.test.R
import com.yklee.test.databinding.ActivityMainBinding
import com.yklee.test.kotlin.viewmodel.MainViewModelKt
import com.yklee.test.retrofithttplibrary.sample.SampleData
import com.yklee.test.retrofithttplibrary.sample.TestRequest

/**
 * Created by yeonggyu.lee on 2018-03-08.
 */
class MainActivityKt : AppCompatActivity() {

    lateinit var mDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mDataBinding.mainViewModel = MainViewModelKt()
        initialize()

        val httpTest = AsyncTaskRequest()
        httpTest.execute()
    }

    inner class AsyncTaskRequest(): AsyncTask<String, Int, Any?>() {
        override fun doInBackground(vararg params: String?): Any? {
            var body: Any?
            try {
                body = TestRequest().request()
            } catch (e: Exception) {
                body = e
                return body
            }
            return body
        }

        override fun onPostExecute(result: Any?) {
            super.onPostExecute(result)
            if (result is Exception) {
                mDataBinding.subView!!.tvHttpResult.text = result.message
            } else {
                mDataBinding.subView!!.tvHttpResult.text = result.toString()
            }
        }
    }

    private fun initialize() {
        setSupportActionBar(mDataBinding.toolbar)
    }
}