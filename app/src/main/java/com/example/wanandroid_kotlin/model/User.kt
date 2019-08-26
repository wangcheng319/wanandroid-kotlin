package com.example.wanandroid_kotlin.model

import androidx.databinding.*

/**
 *
 * @ProjectName:    wanandroid-kotlin
 * @Package:        com.example.wanandroid_kotlin.model
 * @ClassName:      User
 * @Description:     java类作用描述
 * @Author:         wangc
 * @CreateDate:     2019/8/22 17:28
 * @Version:        1.0
 */
class User : BaseObservable() {

    lateinit var name:String

    private val age = ObservableInt()

    fun setAge(age: Int) {
        this.age.set(age)
    }

    fun getAge(): Int {
        return age.get()
    }
}