package com.example.wanandroid_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wanandroid_kotlin.databinding.ItemHomeBinding
import com.example.wanandroid_kotlin.model.Article
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
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
        datas[position]?.let { ViewHolder.bind(holder, it) }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var dataBinding: ItemHomeBinding? = DataBindingUtil.bind(itemView)
        companion object {
            fun bind(viewHolder: ViewHolder, item: Article.Datas){
                viewHolder.dataBinding?.item = item
            }
        }
    }



}
