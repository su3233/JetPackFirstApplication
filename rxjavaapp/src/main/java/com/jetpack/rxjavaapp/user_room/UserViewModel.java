package com.jetpack.rxjavaapp.user_room;

import com.jetpack.rxjavaapp.database.User;
import com.jetpack.rxjavaapp.database.UserDataSource;

import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 17:11
 * @Description： 将room数据的操作实现对象作为参数，使viewModel具有其数据库操作能力
 */

class UserViewModel extends ViewModel {
    private UserDataSource userDataSource;
    private User mUser;

    public UserViewModel(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    Flowable<String> getUserName() {
        return userDataSource.getUsers().map(user -> {
            mUser = user;
            return user.getName();
        });
    }

    Completable insertOrUpdate(String name) {
        mUser = mUser == null ? new User(name) : new User(mUser.getId(), name);
        return userDataSource.insertUser(mUser);
    }

}
