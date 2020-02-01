package com.cse438.tinnews.save

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.cse438.tinnews.common.BaseViewModel
import com.cse438.tinnews.R
import com.squareup.picasso.Picasso

class ImageViewModel(itemResource: Int): BaseViewModel<ImageViewModel.ImageViewModelViewHolder>(itemResource) {

    private lateinit var url: String

    constructor(url: String): this(R.layout.image_layout) {
        this.url = url
    }

    override fun bindViewHolder(holder: ImageViewModelViewHolder) {
        Picasso.get().load(url).into(holder.image)
    }

    override fun createItemViewHolder(view: View): ImageViewModelViewHolder {
        return ImageViewModelViewHolder(view)
    }

    class ImageViewModelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null

        init {
            image = itemView.findViewById(R.id.image)
        }
    }
}