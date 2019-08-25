package com.example.wanandroid_kotlin.http

import android.content.Context
import android.content.SharedPreferences
import com.example.wanandroid_kotlin.App
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject



class ReceivedCookiesInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = arrayListOf<String>()
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }
            var cookieStr = Gson().toJson(cookies)

            var editor = App().applicationContext.getSharedPreferences("cookies", Context.MODE_PRIVATE).edit()
            editor.putString("cookies",cookieStr)
        }

        return originalResponse

    }
}