package com.example.wanandroid_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.databinding.LoginFragmentBinding
import com.example.wanandroid_kotlin.mvvm.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val dataBinding:LoginFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)
        dataBinding.viewModel = viewModel
        dataBinding.setLifecycleOwner { lifecycle }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
