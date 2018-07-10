package com.yklee.test.Util;

/**
 * Created by yeonggyu.lee on 2018-03-07.
 */

public class Utils {
    public static boolean isEmpty(String src) {
        if (src == null || src.equals("") || src.equals("null")) {
            return true;
        }
        return false;
    }
}
