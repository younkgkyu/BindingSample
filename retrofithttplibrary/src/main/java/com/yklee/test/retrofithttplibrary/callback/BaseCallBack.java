package com.yklee.test.retrofithttplibrary.callback;

import com.yklee.test.retrofithttplibrary.data.ResponseData;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public interface BaseCallBack<T> {
    void onSucess(ResponseData<T> response);
    void onFailed(ResponseData<T> response, Throwable t);
}
