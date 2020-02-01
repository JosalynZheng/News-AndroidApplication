package com.cse438.tinnews.save

import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.cse438.tinnews.R
import com.cse438.tinnews.common.BaseViewModel
import com.cse438.tinnews.common.TinFragmentManager
import com.cse438.tinnews.common.Util
import com.cse438.tinnews.retrofit.response.News
//import com.cse438.tinnews.save.detail.SavedNewsDetailedFragment




class SavedNewsViewModel(itemResourceId: Int): BaseViewModel<SavedNewsViewModel.SavedNewsViewHolder>(itemResourceId) {

    class SavedNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var author: TextView
        internal var description: TextView
        internal var icon: ImageView

        init {
            author = itemView.findViewById(R.id.author)
            description = itemView.findViewById(R.id.description)
            icon = itemView.findViewById(R.id.image)
        }
    }


    private var news: News? = null
    private var fragmentManager: TinFragmentManager? = null
    private val ICON_ARRAY = intArrayOf(R.drawable.a_news_icon, R.drawable.g_news_icon, R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon)



    constructor(news: News, tinFragmentManager: TinFragmentManager): this(itemResourceId = R.layout.saved_news_item) {
        this.news = news
        this.fragmentManager = tinFragmentManager
    }

//    fun SavedNewsViewModel(news: News, tinFragmentManager: TinFragmentManager) {
//        BaseViewModel(R.layout.saved_news_item)
//        this.news = news
//        this.fragmentManager = tinFragmentManager
//    }


    override fun createItemViewHolder(view: View): SavedNewsViewHolder {
        return SavedNewsViewHolder(view)
    }

    override fun bindViewHolder(holder: SavedNewsViewHolder) {
        if (!Util.isStringEmpty(news!!.author)) {
            holder.author.text = news!!.author
        }
        holder.description.setText(news!!.description)
        holder.icon.setImageResource(getDrawable())
        holder.itemView.setOnClickListener { v -> fragmentManager!!.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news!!)) }
    }

    @DrawableRes
    private fun getDrawable(): Int {
        return ICON_ARRAY[(Math.random() * 5).toInt()]
    }

}