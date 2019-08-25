package com.example.wanandroid_kotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.fragment.RegistserFragment

class LoginOrRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_or_register)

        var registerFragment = RegistserFragment.newInstance("","")
        var fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.container,registerFragment).commit()

    }
}
