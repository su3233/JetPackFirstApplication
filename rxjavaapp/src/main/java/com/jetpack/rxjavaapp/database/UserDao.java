package com.jetpack.rxjavaapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 16:42
 * @Description：
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM USERS")
    Flowable<User> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(User user);

    @Query("DELETE FROM USERS")
    void deleteAllUser();
}
