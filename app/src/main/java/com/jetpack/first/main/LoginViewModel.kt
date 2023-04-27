package com.jetpack.first.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/4/27 09:59
 * @Description：
 */
class LoginViewModel : ViewModel() {
    val age: LiveData<String>
        get() = _age
    private val _age = MutableLiveData<String>()
}