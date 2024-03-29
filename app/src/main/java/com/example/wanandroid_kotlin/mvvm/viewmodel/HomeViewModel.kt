package com.example.wanandroid_kotlin.mvvm.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wanandroid_kotlin.App
import com.example.wanandroid_kotlin.activity.TestActivity
import com.example.wanandroid_kotlin.http.ApiClient
import com.example.wanandroid_kotlin.http.ApiResponse
import com.example.wanandroid_kotlin.http.BaseDto
import com.example.wanandroid_kotlin.http.NetworkScheduler
import com.example.wanandroid_kotlin.mvvm.model.Article

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


    fun toNext(){
        val intent = Intent(App.context, TestActivity::class.java)
        App.context.startActivity(intent)
    }

    fun getArticleList(){
        ApiClient.instance.init().getArticleList("0").compose(NetworkScheduler.compose())
            .subscribe(object : ApiResponse<Article>(){
                override fun success(data: BaseDto<Article>) {
                    Log.e("+++","success:"+data.data)
                    for (item in data.data?.datas!!){
                        item.envelopePic = "https://user-gold-cdn.xitu.io/2019/5/28/16afeb62060ea77d?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"
                    }
                    datas.value =  data.data?.datas
                }

                override fun failure(statusCode: Int) {

                }

            })
    }

}