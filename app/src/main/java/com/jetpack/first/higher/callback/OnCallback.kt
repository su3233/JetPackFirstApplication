package com.jetpack.first.higher.callback

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:13
 * @Description：
 */
interface OnCallback<T> {
    fun onSuccess(t: T)

    fun onError(s: String)
}