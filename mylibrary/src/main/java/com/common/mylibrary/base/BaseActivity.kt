package com.common.mylibrary.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.common.mylibrary.view.FirstToast

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 16:03
 * @Description：
 */
abstract class BaseActivity : IAction, AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
        click()

    }

    override fun onResume() {
        super.onResume()
        observeData()
    }

    override fun jumpTo(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }

    abstract fun getLayout(): Int

    fun showToast(str: String) {
        FirstToast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}