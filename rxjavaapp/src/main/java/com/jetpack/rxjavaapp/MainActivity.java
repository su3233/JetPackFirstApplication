package com.jetpack.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jetpack.rxjavaapp.base.BaseActivity;
import com.jetpack.rxjavaapp.user_room.UserRoomActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_start).setOnClickListener(v -> {
            startActivity(new Intent(this, UserRoomActivity.class));
        });
    }
}