package com.example.wanandroid_kotlin.fragment


import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.databinding.FragmentRegistserBinding
import com.example.wanandroid_kotlin.viewmodel.RegisterViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RegistserFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataBinding:FragmentRegistserBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_registser,container,false)
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        dataBinding.viewModel = registerViewModel
        dataBinding.setLifecycleOwner { lifecycle }
        return dataBinding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
