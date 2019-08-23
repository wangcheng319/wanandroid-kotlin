package com.example.wanandroid_kotlin.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    var number:MutableLiveData<Int> = MutableLiveData()
    var checkName:MutableLiveData<Boolean> = MutableLiveData()
    var inputText:MutableLiveData<String> = MutableLiveData()

    init {
        number.value = 0
        inputText.value = "please input name"
        checkName.value = true
    }


    fun add(){
        number.value = number.value?.plus(1)
    }

    fun switch(){
        checkName.value = !checkName.value!!
    }
}