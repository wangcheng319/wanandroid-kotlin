package com.example.wanandroid_kotlin.http

import com.example.wanandroid_kotlin.mvvm.model.Article
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("/user/register")
    fun register(@Field("username") username:String, @Field("password") password:String,
                 @Field("repassword") repassword:String): Observable<BaseDto<String>>

    @GET("/article/list/{page}/json")
    fun getArticleList(@Path("page") page:String):Observable<BaseDto<Article>>

}