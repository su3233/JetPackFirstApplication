package com.jetpack.first

import com.common.mylibrary.bean.StudentBean
import kotlinx.coroutines.delay


/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 10:48
 * @Description：
 */
const val DELAY_TIME_NET = 1500L

class KtTest {

    /**
     * 函数做回调
     */
    fun calculateNum(para: Int, para2: Int, block: (Int) -> Int) {
        block(para + para2)
    }

    /**
     * 发送Int不需要结果返回
     */
    fun sendIntNoResult(para: Int, para2: Int, block: (Int) -> Unit) {
        block(para + para2)
    }

    /**
     * suspend函数做回调
     */
    suspend fun getLoginResult(name: String, psw: String, loginResult: suspend (Boolean) -> Unit) {
        if (name.isNotEmpty() && psw.isNotEmpty()) {
            delay(DELAY_TIME_NET)
            loginResult.invoke(true)
        } else {
            delay(DELAY_TIME_NET)
            loginResult.invoke(false)
        }
    }

}

fun main() {
//    val id = "411122199002038371"
//    val c = id.toCharArray()[id.length - 2]
//    println("sex:$c")


    val studentBean = StudentBean("110101199003076296")
    println("studentBean:$studentBean")


    KtTest().sendIntNoResult(112, 221) {
        println("calculateNum:$it")
    }

//    KtTest().calculateNum(112, 221)


}