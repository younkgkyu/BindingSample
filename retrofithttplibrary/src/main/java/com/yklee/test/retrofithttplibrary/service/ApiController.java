package com.yklee.test.retrofithttplibrary.service;

import com.yklee.test.retrofithttplibrary.callback.BaseCallBack;
import com.yklee.test.retrofithttplibrary.data.ResponseData;
import com.yklee.test.retrofithttplibrary.request.BaseParams;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public class ApiController<T> implements IBaseApi<T> {

    @Override
    public ResponseData<T> requestSync(BaseParams params) throws Exception {
        Call<T> call = params.getCallApi();
        ResponseData<T> responseData = new ResponseData<>();
        try {
            Response<T> response = call.execute();
            responseData.setSuccess(true);
            responseData.setData(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return responseData;
    }

    @Override
    public void requestAsync(BaseParams params, final BaseCallBack<T> callBack) {
        Call<T> call = params.getCallApi();
        final ResponseData<T> responseData = new ResponseData<>();

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    responseData.setSuccess(true);
                    responseData.setData(response.body());
                    callBack.onSucess(responseData);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                responseData.setSuccess(false);
                responseData.setErrorMsg(t.getMessage());
                callBack.onFailed(responseData, t);
            }
        });
    }
}
