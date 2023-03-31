package com.jetpack.first.higher.callback

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:15
 * @Description：OnCallback回调-》onSuccessF-》onSuccess函数
 */
class OnCallbackImpl<T> : OnCallback<T> {
    private lateinit var onSuccessF: (T) -> Unit
    private lateinit var onErrorF: (String) -> Unit

    /**
     * 通过这个方法，将onSuccessF方法结果回调出去,listener为相同参数和结果的直接赋值
     */
    fun onSuccessBack(listener: (T) -> Unit) {
        this.onSuccessF = listener
    }

    fun onErrorBack(onError: (String) -> Unit) {
        this.onErrorF = onError
    }

    /**
     * 将onSuccess回调和onSuccessF函数关联，
     */
    override fun onSuccess(t: T) {
        this.onSuccessF(t)
    }

    override fun onError(s: String) {
        this.onErrorF(s)
    }
}