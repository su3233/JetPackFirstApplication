package com.common.mylibrary.bean

import com.common.mylibrary.idConvertSex
import java.util.UUID

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:38
 * @Description：
 */
data class StudentBean(val id: String, val name: String, val sex: Int) {
    constructor(
        idNum: String
    ) : this(
        id = UUID.randomUUID().toString(),
        name = "张三",
        idNum.idConvertSex().ordinal
    )


}
