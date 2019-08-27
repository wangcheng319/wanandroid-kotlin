package com.example.wanandroid_kotlin.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.wanandroid_kotlin.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    fun toRegister(view:View){
        Log.e("+++","toRegister")
        Navigation.findNavController(view).navigate(R.id.action_register_fragment)
    }
}
