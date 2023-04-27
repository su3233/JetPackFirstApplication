package com.common.mylibrary.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.common.mylibrary.view.FirstToast

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 16:03
 * @Description：
 */
abstract class BaseActivity :IAction, AppCompatActivity() {
    fun toastShow(str: String) {
        FirstToast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}