package com.cse438.tinnews.save

import android.graphics.Paint
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.cse438.tinnews.common.BaseViewModel
import com.cse438.tinnews.R
import com.cse438.tinnews.WebViewActivity
import com.cse438.tinnews.WebViewActivity.Companion.URL
import com.cse438.tinnews.common.TinFragmentManager
import java.sql.BatchUpdateException

class ReadmoreViewModel(itemResourceId: Int): BaseViewModel<ReadmoreViewModel.ReadmoreViewModelHolder>(itemResourceId) {

    private lateinit var url: String
    private lateinit var tinFragmentManager: TinFragmentManager

    constructor(url: String, tinFragmentManager: TinFragmentManager): this(R.layout.readmore_layout) {
        this.url = url
        this.tinFragmentManager = tinFragmentManager
    }

    override fun bindViewHolder(holder: ReadmoreViewModelHolder) {
        holder.readMore!!.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.readMore!!.setOnClickListener {
            var bundle = Bundle()
            bundle!!.putString(URL, url)
            tinFragmentManager.startActivityWithBundle(WebViewActivity::class.java, false, bundle)
        }
    }

    override fun createItemViewHolder(view: View): ReadmoreViewModelHolder {
        return ReadmoreViewModelHolder(view)
    }


    class ReadmoreViewModelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var readMore: TextView? = null

        init {
            readMore = itemView.findViewById(R.id.readmore)
        }
    }

}