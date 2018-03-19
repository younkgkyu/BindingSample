package com.yklee.test.retrofithttplibrary.sample

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by yeonggyu.lee on 2018-03-19.
 */
class DefaultHttpClient {
    companion object Factory {
        fun create(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
            return httpClient.build()
        }
    }
}