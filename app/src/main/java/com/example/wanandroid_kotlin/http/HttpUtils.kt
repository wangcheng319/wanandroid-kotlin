package com.example.wanandroid_kotlin.http

class HttpUtils {

    private object Holder {
        val INSTANCE = HttpUtils()
    }
    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}