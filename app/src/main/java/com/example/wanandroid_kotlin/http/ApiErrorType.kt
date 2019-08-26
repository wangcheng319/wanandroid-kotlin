package com.example.wanandroid_kotlin.http

import android.content.Context
import androidx.annotation.StringRes
import com.example.wanandroid_kotlin.R

enum class ApiErrorType(val code: Int, @param:StringRes private val messageId: Int) {
    //根据实际情况进行增删
    INTERNAL_SERVER_ERROR(500,R.string.type_500),
    BAD_GATEWAY(502, R.string.type_500),
    NOT_FOUND(404, R.string.type_500),
    CONNECTION_TIMEOUT(408, R.string.type_500),
    NETWORK_NOT_CONNECT(499, R.string.type_500),
    UNEXPECTED_ERROR(700, R.string.type_500);

    private val DEFAULT_CODE = 1
    fun getApiErrorModel(context: Context): ApiErrorModel {
        return ApiErrorModel(DEFAULT_CODE, context.getString(messageId))
    }
}