package com.cse438.tinnews.tin

import android.widget.ImageView
import android.widget.TextView
import com.cse438.tinnews.R
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Resolve
import com.cse438.tinnews.retrofit.response.News
import com.cse438.tinnews.common.Util
import com.mindorks.placeholderview.annotations.swipe.*
import com.squareup.picasso.Picasso





@Layout(R.layout.tin_news_card)
class TinNewsCard {

    @View(R.id.news_image)
    private lateinit var image: ImageView

    @View(R.id.news_title)
    private lateinit var newsTitle: TextView

    @View(R.id.news_description)
    private lateinit var newsDescription: TextView

    private var news: News? = null
    private var swipeView: SwipePlaceHolderView? = null
    private var onSwipeListener: OnSwipeListener? = null

    constructor(news: News, swipeView: SwipePlaceHolderView, onSwipeListner: OnSwipeListener) {
        this.news = news
        this.swipeView = swipeView
        this.onSwipeListener = onSwipeListner
    }

    @Resolve
    private fun onResolved() {
        if (Util.isStringEmpty(news!!.image)) {
            image.setImageResource((R.drawable.no_image_available))
        } else {
            Picasso.get().load(news!!.image).into(image)
        }
        newsTitle.text = news!!.title
        newsDescription.text = news!!.description
    }


    @SwipeOut
    private fun onSwipeOut() {
        swipeView!!.addView(this)
    }

    @SwipeCancelState
    private fun onSwipeCancelState() {}

    @SwipeIn
    private fun onSwipeIn() {
        onSwipeListener!!.onLike(news!!)
    }

    @SwipeInState
    private fun onSwipeInState() {}

    @SwipeOutState
    private fun onSwipeOutState() {}

    interface OnSwipeListener {
        fun onLike(news: News)
    }
}