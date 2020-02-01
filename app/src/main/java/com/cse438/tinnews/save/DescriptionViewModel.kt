package com.cse438.tinnews.save

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.cse438.tinnews.common.BaseViewModel
import com.cse438.tinnews.R

class DescriptionViewModel(itemResourceId: Int): BaseViewModel<DescriptionViewModel.DescriptionViewHolder>(itemResourceId) {

    private lateinit var description: String

    constructor(description: String): this(R.layout.discription_layout) {
        this.description = description
    }


    override fun bindViewHolder(holder: DescriptionViewHolder) {
        holder.description!!.text = description
    }

    override fun createItemViewHolder(view: View): DescriptionViewHolder {
        return DescriptionViewHolder(view)
    }

    class DescriptionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var description: TextView? = null

        init {
            description = itemView.findViewById(R.id.description)
        }

    }
}