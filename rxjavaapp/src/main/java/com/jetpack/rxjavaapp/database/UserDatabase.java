package com.jetpack.rxjavaapp.database;

import android.content.Context;
import android.support.v4.os.IResultReceiver;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.DeleteTable;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 16:48
 * @Description：
 */

@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    private static volatile UserDatabase ourInstance;

    public abstract UserDao getUserDao();

    public static UserDatabase getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (UserDatabase.class) {
                if (ourInstance == null) {
                    ourInstance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user_data.db").build();
                }
            }
        }
        return ourInstance;
    }

}
