package com.jetpack.first

import android.content.Context
import android.content.SharedPreferences
import com.common.mylibrary.bean.StudentBean
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext


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
    fun sendIntNoResult(para: Int, para2: Int, block: () -> Unit) {
        block()
    }


    /**
     * suspend函数做回调
     */
    suspend fun getLoginResult(name: String, psw: String,dispatcher:CoroutineDispatcher, loginResult: suspend (Boolean) -> Unit) {
        if (name.isNotEmpty() && psw.isNotEmpty()) {
            /**
             * Result 协程内部使用withContext切换上下文
             */
            val result = withContext(coroutineContext) {
                println("${Thread.currentThread()}")
                "coroutineContext....name:$name..psw:$psw"
            }
            println("coroutineContext...result:$result")

            val result2 = withContext(Dispatchers.IO) {
                println("${Thread.currentThread()}")
                "Dispatchers.IO....name:$name..psw:$psw"
            }
            println("Dispatchers.IO...result:$result2")

            delay(DELAY_TIME_NET)
            withContext(dispatcher){
                loginResult.invoke(true)

            }
        } else {
            delay(DELAY_TIME_NET)
            withContext(dispatcher){
                loginResult.invoke(false)

            }
        }
    }

}

fun main() {
//    val id = "411122199002038371"
//    val c = id.toCharArray()[id.length - 2]
//    println("sex:$c")



    val studentBean = StudentBean("110101199003076296")
    val studentBean2 = StudentBean("110101199003076296","su",2)
    println("studentBean:$studentBean")

//    val stu=studentBean.let{
//        it.
//    }


    KtTest().sendIntNoResult(112, 221) {

    }

    KtTest().calculateNum(112, 221) {
        println("calculateNum:$it")
        return@calculateNum it
    }


}