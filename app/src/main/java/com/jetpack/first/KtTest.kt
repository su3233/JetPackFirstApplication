package com.jetpack.first

import android.content.Context
import android.content.SharedPreferences
import com.common.mylibrary.bean.SexEnum.MALE
import com.common.mylibrary.bean.StudentBean
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
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
    suspend fun getLoginResult(
        name: String,
        psw: String,
        dispatcher: CoroutineDispatcher,
        loginResult: suspend (Boolean) -> Unit
    ) {
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
            withContext(dispatcher) {
                loginResult.invoke(true)

            }
        } else {
            delay(DELAY_TIME_NET)
            withContext(dispatcher) {
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
    val studentBean2 = StudentBean("110101199003076296", "su", 2, MALE)
    println("studentBean:$studentBean")

    val stu = studentBean.let {
        it._sex = 2
    }


    KtTest().sendIntNoResult(112, 221) {

    }

    KtTest().calculateNum(112, 221) {
        println("calculateNum:$it")
        return@calculateNum it
    }


    /**
     * 方法的回调，调用。lambda表达式与::的使用，协程的使用
     */
    getName {

    }
    getSex(3, ::calculateSex)
    GlobalScope.launch {
        getResult("account", this.coroutineContext) {

        }
    }
}
fun calculateSex(sex: String) {
    println(sex)
}

/**
 * 方法回调
 *
 * @param callback
 * @receiver
 */
fun getName(callback: () -> Unit) {
    callback.invoke()
}

fun getSex(id: Int, callback: (String) -> Unit) {
    callback.invoke(id.toString())
}

suspend fun getResult(
    account: String,
    scope: CoroutineContext,
    function: suspend (String) -> Unit
) {
//        withContext(scope) {
    withContext(Dispatchers.Main) {
        function.invoke(account)
    }
}