package com.jetpack.first.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


/**
 * @project: JetPackFirstApplication
 * @author: tongSheng.su on 2023/4/27 09:55
 * @Description：
 */
const val key = "NAME"

class MainSaveViewModel(private val handle: SavedStateHandle) :
    ViewModel() {
//    init {
//        if (handle.contains(key).not()) {
//            load()
//        }
//    }

//    private val sp: SharedPreferences =
//        app.getSharedPreferences("SP_JETPACK", Context.MODE_PRIVATE)

    fun getNumber(): MutableLiveData<Int?> { //声明为共有类用以xml中的使用
        if (handle.contains(key).not()) {
            handle.set(key, 0)
        }
        return handle.getLiveData(key)
    }

//    private fun load() {
//        val x = sp.getString(key, "0")
//        handle.set(key, x);//读取
//    }

//    fun save() {
//        val editor = sp.edit();
//        getNumber().value?.let {
//            editor.putInt(
//                key,
//                it
//            )
//        }//warning中说没判空，但是逻辑中我们已经会显示为0。消除警告方法：
//        editor.apply()
//    }

    fun add() {
        getNumber().value = getNumber().value?.plus(1)
//        handle.set(key, if (getNumber().value == null) 0 else getNumber().value?.plus(x))
        //保存法一，但是保存开销大占用内存极高
        //save();
    }
}