package com.jetpack.rxjavaapp.database;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 17:04
 * @Description：
 */

public interface UserDataSource {

    Flowable<User> getUsers();

    Completable insertUser(User user);

    void deleteAllUser();
}
