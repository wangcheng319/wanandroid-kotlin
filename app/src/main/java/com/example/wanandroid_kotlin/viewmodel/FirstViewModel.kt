package com.example.wanandroid_kotlin.viewmodel

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wanandroid_kotlin.activity.TestActivity

class FirstViewModel : ViewModel() {
    var number: MutableLiveData<Int> = MutableLiveData()
    var checkName:MutableLiveData<Boolean> = MutableLiveData()
    var inputText:MutableLiveData<String> = MutableLiveData()

    init {
        number.value = 0
        number.postValue(1)
        inputText.value = "please input name"
        checkName.value = true
    }


    fun add(){
        number.value = number.value?.plus(1)
    }

    fun toNext(view:View){
        val context = view.context
        val intent = Intent(context, TestActivity::class.java)
        context.startActivity(intent)

    }

}