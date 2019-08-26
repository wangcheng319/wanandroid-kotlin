package com.example.wanandroid_kotlin.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wanandroid_kotlin.activity.TestActivity
import com.example.wanandroid_kotlin.http.ApiClient
import com.example.wanandroid_kotlin.http.ApiResponse
import com.example.wanandroid_kotlin.http.BaseDto
import com.example.wanandroid_kotlin.http.NetworkScheduler
import com.example.wanandroid_kotlin.model.Article

class HomeViewModel : ViewModel() {
    var number: MutableLiveData<Int> = MutableLiveData()
    var checkName:MutableLiveData<Boolean> = MutableLiveData()
    var inputText:MutableLiveData<String> = MutableLiveData()
    var datas:MutableLiveData<List<Article.Datas>> = MutableLiveData()

    init {
        number.value = 0
        number.postValue(1)
        inputText.value = "please input name"
        checkName.value = true
    }


    fun toNext(view:View){
        val context = view.context
        val intent = Intent(context, TestActivity::class.java)
        context.startActivity(intent)
    }

    fun getArticleList(){
        ApiClient.instance.init().getArticleList("0").compose(NetworkScheduler.compose())
            .subscribe(object :ApiResponse<Article>(){
                override fun success(data: BaseDto<Article>) {
                    Log.e("+++","success:"+data.data)
                    datas.value =  data.data?.datas
                }

                override fun failure(statusCode: Int) {

                }

            })
    }

}