package com.yklee.test.retrofithttplibrary.request;

import com.yklee.test.retrofithttplibrary.retrofitcore.RetrofitGsonFactory;

import retrofit2.Call;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public abstract class BaseParams {

    protected <T> T create(Class<T> service) {
        return new RetrofitGsonFactory().get().create(service);
    }
    public abstract Call getCallApi();
}
