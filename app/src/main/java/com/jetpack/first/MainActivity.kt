package com.jetpack.first

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.common.mylibrary.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author SuTs
 * @create 17:36 2023/3/28
 * @Describe
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        GlobalScope.launch(Dispatchers.IO) {
            println("GlobalScope：协程中顺序执行")
            delay(3000)
            lifecycleScope.launch(Dispatchers.Main) {
                KtTest().getLoginResult("zhangsan", "123") {
                    val result = if (it) "登录成功" else "登录失败"
                    toastShow(result)
                }
            }
        }

    }

    fun onClickHappen(view: View) {
        toastShow("toast.....")
    }
}