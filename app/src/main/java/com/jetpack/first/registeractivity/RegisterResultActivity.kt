package com.jetpack.first.registeractivity

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.common.mylibrary.base.BaseActivity
import com.jetpack.first.R

class RegisterResultActivity : BaseActivity() {
    private val btRegisterForResult by lazy {
        findViewById<Button>(R.id.bt_register_for_result)
    }

    private val tvRegisterForResult by lazy {
        findViewById<TextView>(R.id.tv_register_for_result)
    }
    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                showToast("存储权限已授权")
            }
        }

    private val permissionsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (it[Manifest.permission.READ_CONTACTS] == true) {
            showToast("已授权读取联系人权限")
        }
    }
    private val forResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == ACTIVITY_RESULT_CODE) {
                val key = it.data?.getStringExtra("key")
                val num = it.data?.getIntExtra("num", 0)
                tvRegisterForResult.text = "key:$key..num:$num"
            }
        }

    override fun getLayout(): Int = R.layout.activity_register_result

    override fun initView() {
//        permissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        permissionsLauncher.launch(
            arrayOf(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                Manifest.permission.CALL_PHONE,
            )
        )
        supportFragmentManager.beginTransaction().apply {
            add(R.id.content_fragment_result, ActivityResultFragment.newInstance("123", "123"))
        }.commit()
    }

    override fun createViewModel() {

    }

    override fun click() {
        btRegisterForResult.setOnClickListener {
            forResultLauncher.launch(Intent(this, RegisterToActivity::class.java))
        }
    }

    override fun observeData() {

    }
}