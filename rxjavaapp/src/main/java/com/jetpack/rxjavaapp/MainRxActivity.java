package com.jetpack.rxjavaapp;

import android.content.Intent;
import android.os.Bundle;

import com.jetpack.rxjavaapp.base.BaseRxActivity;
import com.jetpack.rxjavaapp.user_room.UserRoomRxActivity;

public class MainRxActivity extends BaseRxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_main_user).setOnClickListener(v -> {
            startActivity(new Intent(this, UserRoomRxActivity.class));
        });
    }
}