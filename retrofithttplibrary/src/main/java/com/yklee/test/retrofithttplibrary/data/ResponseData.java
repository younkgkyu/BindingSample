package com.yklee.test.retrofithttplibrary.data;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public class ResponseData<T> {
    /**
     * 성공 여부
     */
    private boolean isSuccess;
    /**
     * http 상태 코드
     */
    private String httpStatusCode;
    /**
     * 에러 메시지(성공시 sucess)
     */
    private String errorMsg;
    private T data;

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "isSuccess=" + isSuccess +
                ", httpStatusCode='" + httpStatusCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
