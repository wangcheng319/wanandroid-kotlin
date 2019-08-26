package com.example.wanandroid_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroid_kotlin.databinding.ItemHomeBinding
import com.example.wanandroid_kotlin.model.Article
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.wanandroid_kotlin.R


class TestAdapter(private val mContext: Context, private val datas: List<Article.Datas>) :
    RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.mTv.text = datas[position].chapterName
        datas[position].chapterName?.let { ViewHolder.bind(holder, it) }
        //设置图片
        holder.dataBinding?.iv?.context?.let { Glide.with(it).load("https://user-gold-cdn.xitu.io/2019/5/28/16afeb62060ea77d?imageView2/0/w/1280/h/960/format/webp/ignore-error/1").into(
            holder.dataBinding!!.iv) }

    }

    override fun getItemCount(): Int {
        return datas.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//         val mTv: TextView = itemView.findViewById(R.id.textView)
         var dataBinding: ItemHomeBinding? = DataBindingUtil.bind(itemView)

        companion object {
            fun bind(viewHolder: ViewHolder, string: String){
                viewHolder.dataBinding?.item = string
            }

            @BindingAdapter("android:src")
            fun setSrc(view: ImageView, resId: Int) {
                view.setImageResource(resId)
            }

            @BindingAdapter("imgUrl")
            fun loadImage(imageView: ImageView, imgUrl: String) {

            }
        }

    }



}
