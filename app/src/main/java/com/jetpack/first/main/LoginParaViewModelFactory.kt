package com.jetpack.first.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/4/27 10:37
 * @Description：
 */
class LoginParaViewModelFactory(private val repository: Repository) :
    ViewModelProvider.AndroidViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginParaViewModel::class.java)) {
            return LoginParaViewModel(repository) as T
        }
        return super.create(modelClass)
    }
}