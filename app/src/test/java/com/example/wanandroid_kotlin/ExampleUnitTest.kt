package com.example.wanandroid_kotlin

import com.example.wanandroid_kotlin.model.User
import org.junit.Test

import org.junit.Assert.*
import kotlin.contracts.ReturnsNotNull

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
     print(b.length)
        print(c?.length)
    }


}
