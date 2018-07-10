package com.yklee.test.kotlin.Utils

/**
 * Created by yeonggyu.lee on 2018-03-12.
 */
class StringUtil {
    companion object {
        fun isEmpty(src: String?): Boolean {
            if (src == null || src.equals("") || src.equals("null")) {
                return true
            }
            return false
        }

//        fun test() {
//
//        }
    }
}