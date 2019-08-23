package com.example.wanandroid_kotlin.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    var number:MutableLiveData<Int> = MutableLiveData()


    fun add(){
        number.value = number.value?.plus(1)
    }
}