package com.common.mylibrary

import com.common.mylibrary.bean.SexEnum

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 12:02
 * @Description：
 */
/**
 * 从身份证号中取得性别
 */
fun String.idConvertSex(): SexEnum {
    println("idNum:$this")
    if (this.length != 18 && this.length != 15) {
        throw IllegalArgumentException("身份证号长度错误")
    }
    var gender = 0
    gender = if (this.length == 18) {
        val c = this.toCharArray()[this.length - 2]
        println("sex:$c")
        c.toString().toInt()
    } else {
        val c = this.toCharArray()[this.length - 1]
        println("sex:$c")
        c.toString().toInt()
    }
    println("gender:$gender")
    return if (gender % 2 == 1) {
        SexEnum.MALE
    } else {
        SexEnum.FEMALE
    }
}