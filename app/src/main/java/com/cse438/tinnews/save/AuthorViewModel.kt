package com.cse438.tinnews.save

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.cse438.tinnews.common.BaseViewModel
import kotlinx.android.synthetic.main.author_layout.view.*
import com.cse438.tinnews.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AuthorViewModel(itemResourceId: Int): BaseViewModel<AuthorViewModel.AuthorViewModelHolder>(itemResourceId) {


    private lateinit var author: String
    private lateinit var timeStamp: String

    constructor(author: String, timeStamp: String): this(R.layout.author_layout) {
        this.author = author
        this.timeStamp = timeStamp
    }



    override fun bindViewHolder(holder: AuthorViewModelHolder) {
        holder.author!!.text = author
        var simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        var date: Date? = null
        var formatTime: String? = null
        try {
            date = simpleDateFormat.parse(timeStamp)
            simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            formatTime = simpleDateFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }


        holder.timeStamp!!.setText(formatTime)

    }

    override fun createItemViewHolder(view: View): AuthorViewModelHolder {
        return AuthorViewModelHolder(view)
    }



    class AuthorViewModelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var author: TextView? = null
        var timeStamp: TextView? = null

        init {
            author = itemView.findViewById(R.id.author)
            timeStamp = itemView.findViewById(R.id.time_stamp)
        }
    }
}