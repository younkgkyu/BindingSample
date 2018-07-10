package com.yklee.test.retrofithttplibrary.request;

import com.yklee.test.retrofithttplibrary.service.ISampleService;

import retrofit2.Call;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public class SampleGitHubParams extends BaseParams {

    private String owner;
    private String repo;

    public SampleGitHubParams(String owner, String repo) {
        this.owner = owner;
        this.repo = repo;
    }

    @Override
    public Call getCallApi() {
        ISampleService service = create(ISampleService.class);
        return service.repoContributors(owner, repo);
    }
}
