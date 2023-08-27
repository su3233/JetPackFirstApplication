package com.jetpack.first.higher.callback

import kotlin.random.Random


/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:28
 * @Description：
 */


fun main() {
    getData(fun OnCallbackImpl<String>.() {
        onSuccessBack {
            println("success:$it")

        }
        onErrorBack {
            println("error:$it")

        }
    })

}

fun getData(callback: OnCallbackImpl<String>.() -> Unit) {
    val back = OnCallbackImpl<String>()
    back.callback()
    if (Random.nextBoolean()) {
        back.onSuccess("success!!")
    } else {
        back.onError("error!!")
    }

}