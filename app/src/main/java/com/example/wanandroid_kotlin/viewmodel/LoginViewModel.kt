package com.example.wanandroid_kotlin.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.wanandroid_kotlin.R

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    fun toRegister(view:View){
        Log.e("+++","toRegister")
        Navigation.findNavController(view).navigate(R.id.action_register_fragment)
    }
}
