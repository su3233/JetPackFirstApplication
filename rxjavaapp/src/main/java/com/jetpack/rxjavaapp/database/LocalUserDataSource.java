package com.jetpack.rxjavaapp.database;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 17:05
 * @Description：
 */

public class LocalUserDataSource implements UserDataSource {

    private UserDao userDao;

    public LocalUserDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Flowable<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public Completable insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public void deleteAllUser() {
        userDao.deleteAllUser();
    }
}
