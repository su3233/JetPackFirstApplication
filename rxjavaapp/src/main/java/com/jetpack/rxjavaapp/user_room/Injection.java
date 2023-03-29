package com.jetpack.rxjavaapp.user_room;

import android.content.Context;

import com.jetpack.rxjavaapp.database.LocalUserDataSource;
import com.jetpack.rxjavaapp.database.UserDataSource;
import com.jetpack.rxjavaapp.database.UserDatabase;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 17:17
 * @Description：
 */

public class Injection {
    public static UserViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource userDataSource = provideUserDataSource(context);
        return new UserViewModelFactory(userDataSource);
    }

    private static UserDataSource provideUserDataSource(Context context) {
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        return new LocalUserDataSource(userDatabase.getUserDao());
    }
}
