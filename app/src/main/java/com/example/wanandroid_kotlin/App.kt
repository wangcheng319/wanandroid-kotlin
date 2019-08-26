package com.example.wanandroid_kotlin

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.wanandroid_kotlin.http.ApiClient

class App :Application(){

    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
        context = this

    }
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

    }
}