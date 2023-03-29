package com.jetpack.rxjavaapp.user_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jetpack.rxjavaapp.BaseActivity;
import com.jetpack.rxjavaapp.R;

public class UserRoomActivity extends BaseActivity {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private UserViewModel userViewModel;
    private TextView tvName, tvTime;
    private TimeViewModel timeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_room);
        EditText etName = findViewById(R.id.et_user_input);
        tvName = findViewById(R.id.tv_user_name);
        tvTime = findViewById(R.id.tv_time_show);
        Button btInsert = findViewById(R.id.bt_user_insert);

        UserViewModelFactory userViewModelFactory = Injection.provideViewModelFactory(this);
        userViewModel = new ViewModelProvider(this, userViewModelFactory).get(UserViewModel.class);

        timeViewModel = new ViewModelProvider(this).get(TimeViewModel.class);

        btInsert.setOnClickListener(v -> {
            btInsert.setEnabled(false);
            compositeDisposable.add(userViewModel.insertOrUpdate(etName.getText().toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action() {
                        @Override
                        public void run() throws Exception {
                            btInsert.setEnabled(true);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Toast.makeText(UserRoomActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                        }
                    }));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        compositeDisposable.add(userViewModel.getUserName().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        tvName.setText(s);
                    }
                }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        compositeDisposable.add(timeViewModel.timeUp().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        tvTime.setText(s);
                    }
                }));
    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}