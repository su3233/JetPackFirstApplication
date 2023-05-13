package com.jetpack.rxjavaapp.user_room;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 18:44
 * @Description：
 */

public class TimeViewModel extends ViewModel {

    public TimeViewModel() {
    }

    public Flowable<String> timeUp() {
        return Flowable.interval(1, TimeUnit.SECONDS).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return aLong.toString();
            }
        }).onBackpressureLatest();
    }
}
