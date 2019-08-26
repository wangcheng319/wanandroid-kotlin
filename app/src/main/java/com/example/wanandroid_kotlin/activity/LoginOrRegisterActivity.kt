package com.example.wanandroid_kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.fragment.RegistserFragment

class LoginOrRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_or_register)

//        var registerFragment = RegistserFragment.newInstance("","")
//        var fragmentManager = supportFragmentManager
//        fragmentManager.beginTransaction().add(R.id.container,registerFragment).commit()

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.my_nav_host_fragment).navigateUp()
    }
}
