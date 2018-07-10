package com.yklee.test.kotlin

import android.databinding.DataBindingUtil
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yklee.test.R
import com.yklee.test.databinding.ActivityMainBinding
import com.yklee.test.kotlin.viewmodel.MainViewModelKt
import com.yklee.test.retrofithttplibrary.callback.BaseCallBack
import com.yklee.test.retrofithttplibrary.data.BaseResultData
import com.yklee.test.retrofithttplibrary.data.Contributor
import com.yklee.test.retrofithttplibrary.data.ResponseData
import com.yklee.test.retrofithttplibrary.data.SampleResultData
import com.yklee.test.retrofithttplibrary.request.BaseParams
import com.yklee.test.retrofithttplibrary.request.SampleGitHubParams
import com.yklee.test.retrofithttplibrary.request.SampleParams
import com.yklee.test.retrofithttplibrary.service.ApiController

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

//        val httpTest = AsyncTaskRequest()
//        httpTest.execute()
        
        val params = SampleGitHubParams("square", "retrofit")

        ApiController<List<Contributor>>().requestAsync(params, object: BaseCallBack<List<Contributor>> {
            override fun onSucess(response: ResponseData<List<Contributor>>?) {
                if (response != null && response.isSuccess) {
                    mDataBinding.subView!!.tvHttpResult.text = response.toString()
                }
            }

            override fun onFailed(response: ResponseData<List<Contributor>>?, t: Throwable?) {
                if (response != null) {
                    mDataBinding.subView!!.tvHttpResult.text = response.errorMsg
                } else if (t != null) {
                    mDataBinding.subView!!.tvHttpResult.text = t.message
                }
            }
        })
    }

    inner class AsyncTaskRequest: AsyncTask<String, Int, ResponseData<List<Contributor>>>() {
        override fun doInBackground(vararg params: String?): ResponseData<List<Contributor>> {
            var body: ResponseData<List<Contributor>>
            try {
                val params = SampleGitHubParams("square", "retrofit")
                body = ApiController<List<Contributor>>().requestSync(params)
            } catch (e: Exception) {
                body = ResponseData()
                body.isSuccess = false
                body.errorMsg = e.message
                return body
            }
            return body
        }

        override fun onPostExecute(result: ResponseData<List<Contributor>>) {
            super.onPostExecute(result)
            if (result != null && result.isSuccess) {
                mDataBinding.subView!!.tvHttpResult.text = result.toString()
            } else {
                mDataBinding.subView!!.tvHttpResult.text = result.errorMsg
            }
        }
    }

    private fun initialize() {
        setSupportActionBar(mDataBinding.toolbar)
    }
}