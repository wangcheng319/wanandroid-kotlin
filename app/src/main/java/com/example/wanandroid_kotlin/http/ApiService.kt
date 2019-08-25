package com.example.wanandroid_kotlin.http

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/user/register")
    fun register(@Field("username") username:String, @Field("password") password:String,
                 @Field("repassword") repassword:String): Observable<BaseDto<String>>

}