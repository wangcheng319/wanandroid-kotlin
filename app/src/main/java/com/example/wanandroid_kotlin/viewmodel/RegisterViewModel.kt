package com.example.wanandroid_kotlin.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.wanandroid_kotlin.http.*

class RegisterViewModel: ViewModel() {

     var userName: MutableLiveData<String> = MutableLiveData()
     var passWord:MutableLiveData<String> = MutableLiveData()
     var repassWord:MutableLiveData<String> = MutableLiveData()
     var result:MutableLiveData<String> = MutableLiveData()
     var isCheck:MutableLiveData<Boolean> = MutableLiveData()

    init {
        userName.value = ""
        passWord.value = ""
        repassWord.value = ""
        result.value = ""
        isCheck.value = false
    }

    fun register(){
        Log.e("+++","方法调用")
        if (userName.value?.isEmpty()!!){
            Log.e("+++","用户名不能为空")
            return
        }

        if (isCheck.value!=true){
            Log.e("+++","请勾选协议")
            return
        }

        ApiClient.instance.init().register(username = "wangc",password = "123456",repassword = "123456")
            .compose(NetworkScheduler.compose())
            .subscribe(object :ApiResponse<String>(){
                override fun success(data: BaseDto<String>) {
                    Log.e("+++",""+data.errorMsg)
                }

                override fun failure(statusCode: Int) {
                    Log.e("+++", "失败$statusCode")
                }
            })
    }

    fun toLogin(view:View){
        Navigation.findNavController(view).navigateUp()
    }




}