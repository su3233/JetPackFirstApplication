package com.jetpack.first.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.common.mylibrary.base.BaseActivity
import com.jetpack.first.KtTest
import com.jetpack.first.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author SuTs
 * @create 17:36 2023/3/28
 * @Describe viewmodel的创建和几种使用方式 by viewModels、ViewModelProvider,需要参数的自定义factory
 */
class MainActivity : BaseActivity() {
    private val tvShow: TextView by lazy {
        findViewById<TextView>(R.id.tv_main_show)
    }
    private val btAdd: TextView by lazy {
        findViewById<Button>(R.id.bt_main_add)
    }
    private val btMinus: TextView by lazy {
        findViewById<Button>(R.id.bt_main_minus)
    }

    val loginViewModel2 by viewModels<LoginViewModel>()
    val loginViewModel3 by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    /**
     * 使用viewModel+Sp进行数据保存
     */
    val mainSaveViewModel: MainSaveViewModel by lazy {
        ViewModelProvider(
            this,
            SavedStateViewModelFactory(application, this)
        ).get(MainSaveViewModel::class.java)
    }



    /**
     * Main view model需要参数
     */
    private val loginParaViewModel by lazy {
        ViewModelProvider(
            this,
            LoginParaViewModelFactory(Repository())
        ).get(LoginParaViewModel::class.java)
    }


    val mainViewModel by viewModels<MainViewModel>()
    val mainViewModel3 by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private lateinit var mainViewModel2: MainViewModel

    override fun createViewModel() {
        /***
         * viewModel创建的几种方式 ViwModelProvider（带参数的使用factory，使用context的集成AndroidViewModel）
         */
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        mainViewModel2 = ViewModelProvider(this)[MainViewModel::class.java]


    }

    override fun onPause() {
        super.onPause()
//        mainSaveViewModel.save()
    }

    override fun onResume() {
        super.onResume()
        mainSaveViewModel.getNumber().observe(this) {
            it?.let {
                tvShow.text = "$it"
            }
        }
    }

    override fun jump() {

    }

    override fun click() {
        btAdd.setOnClickListener {
            mainSaveViewModel.add()
        }
        btAdd.setOnClickListener {
//            mainSaveViewModel.add(-1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {

        GlobalScope.launch(Dispatchers.IO) {
            coroutineScope{

            }

            println("GlobalScope：协程中顺序执行")
            delay(3000)
//            lifecycleScope.launch(Dispatchers.Main) {
                KtTest().getLoginResult("zhangsan", "123",Dispatchers.Main) {
                    val result = if (it) "登录成功" else "登录失败"
                    toastShow(result)
                }
//            }
        }


    }

    fun onClickHappen(view: View) {
        toastShow("toast.....")
    }
}