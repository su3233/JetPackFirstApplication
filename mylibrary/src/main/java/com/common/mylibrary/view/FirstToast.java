package com.common.mylibrary.view;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.common.mylibrary.R;


public class FirstToast {
    private static FirstToast INSTANCE;
    private final TextView textView;
    private Toast mToast;
    private static final String TAG = FirstToast.class.getSimpleName();

    private FirstToast(Context context, CharSequence text, int duration) {

        View v = LayoutInflater.from(context).inflate(R.layout.base_first_toast, null);

        textView = (TextView) v.findViewById(R.id.textToast);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
        mToast.setGravity(Gravity.BOTTOM, 0, 300);
    }

    public static FirstToast makeText(Context context, CharSequence text, int duration) {
        if (INSTANCE == null) {
            INSTANCE = new FirstToast(context, text, duration);
        }
        INSTANCE.textView.setText(text);
        return INSTANCE;
    }

    public void show() {
        Log.d(TAG, "show : " + (mToast != null));
        if (mToast != null) {
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }
}
