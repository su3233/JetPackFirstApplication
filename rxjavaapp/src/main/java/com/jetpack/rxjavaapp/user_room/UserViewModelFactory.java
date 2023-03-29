package com.jetpack.rxjavaapp.user_room;

import com.jetpack.rxjavaapp.database.UserDataSource;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 17:13
 * @Description： 使用工厂类提供数据库操作的UserViewModel对象
 */

class UserViewModelFactory implements ViewModelProvider.Factory {
    private UserDataSource userDataSource;

    public UserViewModelFactory(UserDataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(userDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
