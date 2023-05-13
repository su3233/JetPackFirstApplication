package com.common.mylibrary

import com.common.mylibrary.bean.AnimalBean
import com.common.mylibrary.bean.StudentBean

/**
 * @author SuTs
 * @create 11:53 2023/3/31
 * @Describe
 */

fun main() {
    println("sexTest:${"411122199002038371".idConvertSex()}")

    val studentBean = StudentBean("110101199003076296")
    println("studentBean:$studentBean")

    val animalBean = AnimalBean(_name = "cat", _age = 3)
    animalBean._name = "dog"
    println("animal:$animalBean .. ${animalBean.age}")
}