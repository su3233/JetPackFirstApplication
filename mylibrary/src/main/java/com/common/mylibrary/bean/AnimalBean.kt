package com.common.mylibrary.bean

import java.util.UUID

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:43
 * @Description：将_age声明为private var并通过定义val age 只提供age的get方法
 */
data class AnimalBean constructor(
    val id: String = UUID.randomUUID().toString(),
    var _name: String,
    private var _age: Int
) {
    val age
        get() = "年龄：$_age"


    val name
        get() = _name
}
