package com.yklee.test.retrofithttplibrary.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeonggyu.lee on 2018-03-21.
 */

public class BaseResultData implements Parcelable {

    /**
     * 객체 직렬화를 위해 선언
     */
    public final static Parcelable.Creator CREATOR = new Parcelable.Creator(){

        public final String LOG_TAG = getClass().getSimpleName();

        public BaseResultData createFromParcel(Parcel source){
            try {
                Object entity = Class.forName((source.readString())).newInstance();

                for(Field field : entity.getClass().getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        if(field.getType().equals(java.util.List.class)) {
                            ArrayList list = new ArrayList();
                            source.readList(list, Class.forName(field.getDeclaringClass().getName()).getClassLoader());
                            field.set(entity, list);
                        }else if(field.getType().equals(java.util.Map.class)) {
                            Map map = new HashMap();
                            source.readMap(map, Class.forName(field.getDeclaringClass().getName()).getClassLoader());
                            field.set(entity, map);
                        }else
                            field.set(entity, source.readValue(field.getType().getClassLoader()));

                    } catch (Exception err) {
                        Log.w(LOG_TAG, err.toString());
                    }
                }
                return (BaseResultData) entity;
            } catch (Exception err) {
                return null;
            }
        }

        public BaseResultData[] newArray(int size){
            return this.newArray(size);
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){

        dest.writeString(this.getClass().getCanonicalName());

        for(Field field : this.getClass().getDeclaredFields()) {
            try {
                if(field.getType().equals(java.util.List.class)) {
                    field.setAccessible(true);
                    dest.writeList((List) field.get(this));

                } else if(field.getType().equals(java.util.Map.class)) {
                    field.setAccessible(true);
                    dest.writeMap((Map) field.get(this));

                } else {
                    field.setAccessible(true);
                    dest.writeValue(field.get(this));

                }
            } catch (Exception err) {
                Log.w("BaseResultData", err.toString());
            }
        }
    }
}
