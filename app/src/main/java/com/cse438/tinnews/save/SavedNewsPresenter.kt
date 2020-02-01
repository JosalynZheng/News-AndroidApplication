package com.cse438.tinnews.save

import com.cse438.tinnews.retrofit.response.News

class SavedNewsPresenter : SavedNewsContract.Presenter {

    private lateinit var model: SavedNewsContract.Model
    private lateinit var view: SavedNewsContract.View
//    private lateinit var view2: SavedNewsContract.View

    init {
        model = SavedNewsModel()
        model.setPresenter(this)
    }

    override fun onCreate() {

    }

    override fun onDestroy() {

    }

    override fun onViewAttached(view: SavedNewsContract.View) {
        this.view = view
        this.model.fetchData()
    }

    override fun onViewDetached() {
        // TODO: how to detach
//        this.view = view2
    }

    override fun loadSavedNews(newsList: MutableList<News>?) {
        view.loadSavedNews(newsList)
    }
}