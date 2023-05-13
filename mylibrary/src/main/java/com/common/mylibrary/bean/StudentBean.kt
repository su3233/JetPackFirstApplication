package com.common.mylibrary.bean

import android.os.Parcelable
import com.common.mylibrary.bean.SexEnum.MALE
import com.common.mylibrary.idConvertSex
import kotlinx.parcelize.Parcelize
import java.lang.reflect.Array.get
import java.util.UUID

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/3/31 11:38
 * @Description：
 */
@Parcelize
data class StudentBean(val id: String, val name: String, var _sex: Int, var sexEnum: SexEnum) :
    Parcelable {
    constructor(
        idNum: String
    ) : this(
        id = UUID.randomUUID().toString(),
        name = "张三",
        idNum.idConvertSex().ordinal,
        sexEnum = MALE
    )

    val sex
        get() = "性别：$_sex"


}
