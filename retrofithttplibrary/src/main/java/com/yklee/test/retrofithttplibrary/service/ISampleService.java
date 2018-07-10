package com.yklee.test.retrofithttplibrary.service;

import com.yklee.test.retrofithttplibrary.data.Contributor;
import com.yklee.test.retrofithttplibrary.data.SampleResultData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public interface ISampleService {

    @GET("posts/{userId}")
    Call<SampleResultData> sampleRequest(@Path("userId") String userId);

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
}
