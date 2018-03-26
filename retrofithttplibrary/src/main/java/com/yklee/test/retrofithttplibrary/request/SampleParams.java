package com.yklee.test.retrofithttplibrary.request;

import com.yklee.test.retrofithttplibrary.service.ISampleService;

import retrofit2.Call;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public class SampleParams extends BaseParams {

    private String params;

    public SampleParams(String params) {
        this.params = params;
    }

    @Override
    public Call getCallApi() {
        ISampleService service = create(ISampleService.class);
        return service.sampleRequest("100");
    }
}
