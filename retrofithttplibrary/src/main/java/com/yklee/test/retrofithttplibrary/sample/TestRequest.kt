package com.yklee.test.retrofithttplibrary.sample

/**
 * Created by yeonggyu.lee on 2018-03-19.
 */
open class TestRequest {

    fun request(): Any? {
        var body: Any?
        try {
            val call = GitHubService.create().repoContributors("square", "retrofit")
            body = call.execute().body()
        } catch (e: Exception) {
            body = e
            return body
        }
        return body
    }

}