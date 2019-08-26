package com.example.wanandroid_kotlin.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.databinding.BindingAdapter

class ImageBindingAdapter {
    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun bindImageUrl(view: ImageView, imageUrl: String) {
            val options = RequestOptions()
                .centerCrop()
                .dontAnimate()

            Glide.with(view)
                .load(imageUrl)
                .apply(options)
                .into(view)
        }
    }

}