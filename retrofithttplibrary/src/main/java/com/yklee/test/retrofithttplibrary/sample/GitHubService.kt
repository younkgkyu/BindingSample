package com.yklee.test.retrofithttplibrary.sample

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 * Created by yeonggyu.lee on 2018-03-19.
 */
interface GitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    fun repoContributors(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<SampleData>>

    companion object Factory {
        fun create(): GitHubService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(DefaultHttpClient.create())
                    .build()

            return retrofit.create(GitHubService::class.java)
        }
    }
}