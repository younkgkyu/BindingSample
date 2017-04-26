package com.yklee.test.data;

import java.io.Serializable;

/**
 * Created by yeonggyu.lee on 2017-04-26.
 */

public class UserData implements Serializable {

    private String name;
    private String age;

    public UserData(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
