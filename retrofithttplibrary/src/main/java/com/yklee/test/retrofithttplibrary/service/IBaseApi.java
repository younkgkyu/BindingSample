package com.yklee.test.retrofithttplibrary.service;

import com.yklee.test.retrofithttplibrary.callback.BaseCallBack;
import com.yklee.test.retrofithttplibrary.data.BaseResultData;
import com.yklee.test.retrofithttplibrary.data.ResponseData;
import com.yklee.test.retrofithttplibrary.request.BaseParams;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public interface IBaseApi<T> {
    /**
     * 동기식 통신 Main Ui Thread 호출 금지
     * @return
     */
    ResponseData requestSync(BaseParams params) throws Exception;

    /**
     * 비동기 통신
     * @param callBack 응답 리스너
     */
    void requestAsync(BaseParams params, BaseCallBack<T> callBack);
}
