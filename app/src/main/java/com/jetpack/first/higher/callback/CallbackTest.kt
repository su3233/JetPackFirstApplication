package com.jetpack.first.higher.callback


/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:28
 * @Description：
 */


fun main() {
//AnimalBean
}

fun getData(callback: OnCallbackImpl<String>.() -> Unit) {
    val back=OnCallbackImpl<String>()
    back.callback()

//    back.onSuccess()

}