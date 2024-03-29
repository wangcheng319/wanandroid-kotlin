package com.example.wanandroid_kotlin.http

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


abstract class ApiResponse<T> : Observer<BaseDto<T>> {
    abstract fun success(data: BaseDto<T>)
    abstract fun failure(statusCode: Int)


    override fun onSubscribe(d: Disposable) {
//        LoadingDialog.show(context)
    }

    override fun onNext(t: BaseDto<T>) {
        Log.e("+++","onNext")
        success(t)
    }

    override fun onComplete() {
//        LoadingDialog.cancel()
    }

    override fun onError(e: Throwable) {
        Log.e("+++","onError")
//        LoadingDialog.cancel()
        if (e is HttpException) {//连接服务器成功但服务器返回错误状态码
//            val apiErrorModel: ApiErrorModel = when (e.code()) {
//                ApiErrorType.INTERNAL_SERVER_ERROR.code ->
//                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
//                ApiErrorType.BAD_GATEWAY.code ->
//                    ApiErrorType.BAD_GATEWAY.getApiErrorModel(context)
//                ApiErrorType.NOT_FOUND.code ->
//                    ApiErrorType.NOT_FOUND.getApiErrorModel(context)
//                else -> otherError(e)
//            }
            failure(e.code())
            return
        }
        val apiErrorType: ApiErrorType = when (e) {//发送网络问题或其它未知问题，请根据实际情况进行修改
            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
            is SocketTimeoutException -> ApiErrorType.CONNECTION_TIMEOUT
            else -> ApiErrorType.UNEXPECTED_ERROR
        }
        failure(apiErrorType.code)
    }

    private fun otherError(e: HttpException) =
        Gson().fromJson(e.response()?.errorBody()?.charStream(), ApiErrorModel::class.java)
}