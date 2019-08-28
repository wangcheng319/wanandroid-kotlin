package com.example.wanandroid_kotlin.mvvm.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.wanandroid_kotlin.http.ApiClient
import com.example.wanandroid_kotlin.http.ApiResponse
import com.example.wanandroid_kotlin.http.BaseDto
import com.example.wanandroid_kotlin.http.NetworkScheduler
import com.example.wanandroid_kotlin.mvvm.model.Article

/**
 *
 * @ProjectName:    wanandroid-kotlin
 * @Package:        com.example.wanandroid_kotlin.model.repository
 * @ClassName:      HomeRepository
 * @Description:     java类作用描述
 * @Author:         wangc
 * @CreateDate:     2019/8/27 14:39
 * @Version:        1.0
 */
class HomeRepository {

    fun getArticleList() : List<Article.Datas>? {
        var datas: MutableLiveData<List<Article.Datas>> = MutableLiveData()
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
        return datas.value
    }


    companion object {

        private lateinit var instance: HomeRepository

        fun getInstance(): HomeRepository {
            if (!::instance.isInitialized) {
                synchronized(HomeRepository::class.java) {
                    if (!::instance.isInitialized) {
                        instance = HomeRepository()
                    }
                }
            }
            return instance
        }

    }
}