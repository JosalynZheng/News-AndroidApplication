package com.cse438.tinnews.tin

import com.cse438.tinnews.retrofit.response.News

class TinPresenter : TinContract.Presenter {

    private lateinit var view: TinContract.View
//    private lateinit var view2: TinContract.View

    private lateinit var model: TinContract.Model

    init {
        this.model = TinModel()
        this.model.setPresenter(this)
    }

    override fun onCreate() {

    }

    override fun onDestroy() {

    }

    override fun onViewAttached(view: TinContract.View) {
        this.view = view
        this.model.fetchData()
    }

    override fun onViewDetached() {
        // TODO: how to detach
//        this.view = view2
    }

    override fun showNewsCard(newsList: MutableList<News>?) {
        this.view.showNewsCard(newsList)
    }

    override fun saveFavouriteNews(news: News?) {
        model.saveFavouriteNews(news)
    }
}