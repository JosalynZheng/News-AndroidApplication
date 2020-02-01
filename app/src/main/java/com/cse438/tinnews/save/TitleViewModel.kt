package com.cse438.tinnews.save

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.cse438.tinnews.common.BaseViewModel
import kotlinx.android.synthetic.main.title_layout.view.*
import com.cse438.tinnews.R

class TitleViewModel(itemResourceId: Int): BaseViewModel<TitleViewModel.TitleViewModelHolder>(itemResourceId) {

    private lateinit var title: String

    constructor(title: String): this(R.layout.title_layout) {
        this.title = title
    }


    override fun bindViewHolder(holder: TitleViewModelHolder) {
        holder.title!!.text = title
    }

    override fun createItemViewHolder(view: View): TitleViewModelHolder {
        return TitleViewModelHolder(view)
    }

    class TitleViewModelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        init {
            title = itemView.findViewById(R.id.title)
        }
    }
}