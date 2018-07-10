package com.yklee.test.retrofithttplibrary.retrofitcore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeonggyu.lee on 2018-03-22.
 */

public class NetworkHeader {

    /**
     * 헤더 Map
     */
    private Map<String, String> headers = null;

    public NetworkHeader() {
        headers = new HashMap<>();
    }

    public Map<String, String> getHeaderMap() {
        return headers;
    }

    /**
     * 헤더를 모두 삭제합니다.
     */
    public void cleanHeaders() {
        headers.clear();
    }

    /**
     * 헤더를 추가합니다.
     *
     * @param key   String header key
     * @param value String header value
     */
    public void addHeader(String key, String value) {
        if (key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
            headers.put(key, value);
        }
    }

    public void setHeaders(Map<String, String> headers){
        this.headers = headers;
    }

    /**
     * 헤더를 삭제합니다.
     *
     * @param key
     */
    public void removeHeaderforKey(String key) {
        if (headers.containsKey(key)) {
            headers.remove(key);
        }
    }

    /**
     * 헤더 사용 여부
     */
    public boolean isHeader() {
        if (headers.isEmpty()) {
            return false;
        }
        return true;
    }

}
