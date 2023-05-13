package com.jetpack.rxjavaapp.base;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/29 19:18
 * @Description：
 */

public class BaseRxActivity extends AppCompatActivity {
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
