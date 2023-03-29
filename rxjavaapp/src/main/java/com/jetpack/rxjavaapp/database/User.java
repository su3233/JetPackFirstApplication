package com.jetpack.rxjavaapp.database;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 16:37
 * @Description：
 */
@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id")
    private String id;

    @ColumnInfo(name = "user_name")
    private String name;

    @Ignore
    public User(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public User(@NonNull String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
