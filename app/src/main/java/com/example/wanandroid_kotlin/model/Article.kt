package com.example.wanandroid_kotlin.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.util.*

/**
 *
 * @ProjectName:    wanandroid-kotlin
 * @Package:        com.example.wanandroid_kotlin.model
 * @ClassName:      Article
 * @Description:     java类作用描述
 * @Author:         wangc
 * @CreateDate:     2019/8/26 15:26
 * @Version:        1.0
 */
class Article {
     val curPage: Int = 0
     val datas: List<Datas>? = null
     val offset: Int = 0
     val over: Boolean = false
     val pageCount: Int = 0
     val size: Int = 0
     val total: Int = 0


    class Datas{
         val apkLink: String? = null
         val author: String? = null
         val chapterId: Int = 0
         val chapterName: String? = null
         val collect: Boolean = false
         val courseId: Int = 0
         val desc: String? = null
         var envelopePic: String? = null
         val fresh: Boolean = false
         val id: Int = 0
         val link: String? = null
         val niceDate: String? = null
         val origin: String? = null
         val prefix: String? = null
         val projectLink: String? = null
         val publishTime: Long = 0
         val superChapterId: Int = 0
         val superChapterName: String? = null
         val tags: List<Tags>? = null
         val title: String? = null
         val type: Int = 0
         val userId: Int = 0
         val visible: Int = 0
         val zan: Int = 0
    }

    class Tags{
        val name: String? = null
        val url: String? = null
    }
}