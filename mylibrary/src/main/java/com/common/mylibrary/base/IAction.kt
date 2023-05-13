package com.common.mylibrary.base

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/4/27 10:07
 * @Description：
 */
interface IAction {

    fun initView()

    fun createViewModel()

    fun jumpTo(clazz: Class<*>)

    fun click()

    fun observeData()
}