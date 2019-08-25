package com.example.wanandroid_kotlin

import android.app.Application
import com.example.wanandroid_kotlin.http.ApiClient

class App :Application(){

    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
    }
}