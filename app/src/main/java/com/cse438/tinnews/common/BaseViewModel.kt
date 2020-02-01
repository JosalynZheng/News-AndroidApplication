package com.cse438.tinnews.common

import android.support.v7.widget.RecyclerView
import android.icu.lang.UCharacter.GraphemeClusterBreak
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



abstract class BaseViewModel<V: RecyclerView.ViewHolder>(itemResourceId: Int) {
    private var itemResourceId: Int = 0


    init {
        this.itemResourceId = itemResourceId
    }


    fun createViewHolder(parent: ViewGroup): V {
        val view = LayoutInflater.from(parent.context).inflate(itemResourceId, parent, false)
        return createItemViewHolder(view)
    }


    abstract fun createItemViewHolder(view: View): V


    abstract fun bindViewHolder(holder: V)


    fun getViewType(): Int {
        return itemResourceId
    }
}