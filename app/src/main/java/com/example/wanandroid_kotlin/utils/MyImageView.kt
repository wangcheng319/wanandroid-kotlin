package com.example.wanandroid_kotlin.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide


class MyImageView(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {
    fun setImageUrl(url: String) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}