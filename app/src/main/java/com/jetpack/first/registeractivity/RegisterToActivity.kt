package com.jetpack.first.registeractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.os.bundleOf
import com.common.mylibrary.base.BaseActivity
import com.jetpack.first.R

const val ACTIVITY_RESULT_CODE = 100

class RegisterToActivity : BaseActivity() {
    private val btRegisterTo by lazy {
        findViewById<Button>(R.id.bt_register_result_to)
    }

    override fun getLayout(): Int = R.layout.activity_register_to

    override fun initView() {

    }

    override fun createViewModel() {

    }

    override fun click() {
        btRegisterTo.setOnClickListener {
            val intent = Intent(this, RegisterResultActivity::class.java).apply {
                putExtras(bundleOf(Pair("key", "result"), Pair("num", 123)))
            }
            setResult(ACTIVITY_RESULT_CODE, intent)
            finish()
        }
    }

    override fun observeData() {

    }
}