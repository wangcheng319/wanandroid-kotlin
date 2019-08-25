package com.example.wanandroid_kotlin.http

open class BaseDto<T> {
    var data: T? = null
    var errorCode:Int =0
    var errorMsg:String =""
}