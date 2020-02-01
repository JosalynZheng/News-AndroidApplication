package com.cse438.tinnews.save

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.cse438.tinnews.R
import com.cse438.tinnews.common.TinFragmentManager
import com.cse438.tinnews.retrofit.response.News

import android.view.LayoutInflater
import android.support.annotation.DrawableRes
import java.util.*


class SavedNewsAdapter(tinFragmentManager: TinFragmentManager) : RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder>() {

    private var newsList: MutableList<News>? = null
    private var fragmentManager: TinFragmentManager? = null

    init {
        this.fragmentManager = tinFragmentManager
        this.newsList = LinkedList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNewsViewHolder? {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_news_item, parent, false)
        return SavedNewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: SavedNewsViewHolder, position: Int) {
        val news = newsList!!.get(position)
        holder.author.text = news.author
        holder.description.text = news.description
        holder.icon.setImageResource(getDrawable())
        holder.itemView.setOnClickListener { v -> fragmentManager!!.doFragmentTransaction(SavedNewsDetailedFragment.newInstance(news)) }
    }

    override fun getItemCount(): Int {
        return newsList!!.size
    }

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


    @DrawableRes
    private fun getDrawable(): Int {
        return ICON_ARRAY[(Math.random() * 5).toInt()]
    }


//    fun SavedNewsAdapter(tinFragmentManager: TinFragmentManager) {
//        this.fragmentManager = tinFragmentManager
//        this.newsList = LinkedList()
//
//    }

    fun setNewsList(newsList: MutableList<News>) {
        this.newsList!!.clear()
        this.newsList?.addAll(newsList)
        notifyDataSetChanged()
    }


    companion object {
        private val ICON_ARRAY = intArrayOf(R.drawable.a_news_icon, R.drawable.g_news_icon, R.drawable.c_news_icon, R.drawable.y_news_icon, R.drawable.m_news_icon)
    }
}


