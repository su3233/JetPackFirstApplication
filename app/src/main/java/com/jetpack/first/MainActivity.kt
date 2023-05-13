package com.jetpack.first

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.common.mylibrary.base.BaseActivity
import com.jetpack.first.R.id
import com.jetpack.first.viewmodel.LoginParaViewModel
import com.jetpack.first.viewmodel.LoginParaViewModelFactory
import com.jetpack.first.viewmodel.LoginViewModel
import com.jetpack.first.viewmodel.MainSaveViewModel
import com.jetpack.first.viewmodel.MainViewModel
import com.jetpack.first.viewmodel.Repository
import com.jetpack.first.viewmodel.ViewModelActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author SuTs
 * @create 17:36 2023/3/28
 * @Describe viewmodel的创建和几种使用方式 by viewModels、ViewModelProvider,需要参数的自定义factory
 */
class MainActivity : BaseActivity() {
    private val btViewModel by lazy {
        findViewById<Button>(R.id.bt_main_viewmodel)
    }

    override fun createViewModel() {

    }


    override fun click() {
        btViewModel.setOnClickListener { jumpTo(ViewModelActivity::class.java) }

    }

    override fun observeData() {

    }


    override fun getLayout() = R.layout.activity_main

    override fun initView() {


    }

}