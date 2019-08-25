package com.example.wanandroid_kotlin.http

import android.content.Context
import android.util.Log
import com.example.wanandroid_kotlin.App
import okhttp3.Interceptor
import okhttp3.Response

class AddCookiesInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val cookieStr = App().getSharedPreferences("cookies", Context.MODE_PRIVATE).getString("cookies","")
        if (cookieStr != null) {
            for (cookie in cookieStr!!) {
                builder.addHeader("Cookie", cookieStr)
                Log.v(
                    "OkHttp",
                    "Adding Header: $cookie"
                ) // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            }
        }
        return chain.proceed(builder.build())

    }
}