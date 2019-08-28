package com.example.wanandroid_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wanandroid_kotlin.R
import com.example.wanandroid_kotlin.mvvm.model.Article
import kotlinx.android.synthetic.main.item_home.view.*


class TestAdapter(private val mContext: Context, private val datas: List<Article.Datas>) :
    RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        datas[position]?.let { ViewHolder.bind(holder, it) }
        holder.itemView.btn_add.setOnClickListener { add(position) }
        holder.itemView.btn_reduce.setOnClickListener { reduce(position) }
    }

    private fun reduce(position: Int) {
        datas[position].zan--
        notifyItemChanged(position)
    }

    private fun add(position: Int) {
        datas[position].zan++
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var dataBinding: com.example.wanandroid_kotlin.databinding.ItemHomeBinding? = DataBindingUtil.bind(itemView)
        companion object {
            fun bind(viewHolder: ViewHolder, item: Article.Datas){
                viewHolder.dataBinding?.item = item
            }
        }


    }





}
