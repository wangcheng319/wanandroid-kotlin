package com.example.wanandroid_kotlin

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private  var b:String = "b"
    private var c:String? = null

    @Test
    fun addition_isCorrect() {
        Observable.interval(5, TimeUnit.SECONDS, Schedulers.io())
            .subscribe { tick -> print(tick) }
    }


}
