package com.yklee.test.viewmodel;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by yeonggyu.lee on 2018-03-07.
 */

public interface IBaseViewModel {
    void onCreate(@Nullable Bundle savedInstanceState);
    void onResume();
    void onPause();
    void onDestory();
}
