package com.yklee.test.retrofithttplibrary.retrofitcore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.yklee.test.retrofithttplibrary.NetworkConst;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yeonggyu.lee on 2018-03-22.
 */

public class RetrofitGsonFactory extends AbsRetrofitFactory {

    @Override
    protected OkHttpClient getClient() {
        return null;
    }

    @Override
    protected Converter.Factory getConverterFactory() {
        TypeAdapterFactory typeAdapterFactory = new JsonTypeAdapterFactory();
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).setLenient().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create();
        return GsonConverterFactory.create(gson);
    }

    @Override
    protected NetworkHeader getHeader() {
        return null;
    }

    @Override
    protected String getDefaultUrl() {
        return NetworkConst.DEFAULT_URL;
    }
}
