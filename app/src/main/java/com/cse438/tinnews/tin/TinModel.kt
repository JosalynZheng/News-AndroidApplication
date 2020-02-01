package com.cse438.tinnews.tin

import android.annotation.SuppressLint
import com.cse438.tinnews.TinApplication
import com.cse438.tinnews.database.AppDatabase
import com.cse438.tinnews.retrofit.NewsRequestApi
import com.cse438.tinnews.retrofit.RetrofitClient
import com.cse438.tinnews.retrofit.response.News
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Completable


class TinModel : TinContract.Model {

    private lateinit var presenter : TinContract.Presenter
    private var newsRequestApi: NewsRequestApi
    private var db: AppDatabase

    init {
        newsRequestApi = RetrofitClient.getMyInstance().create(NewsRequestApi::class.java)
        db = TinApplication.database
    }

    override fun setPresenter(presenter: TinContract.Presenter) {
        this.presenter = presenter
    }

    override fun fetchData() {
        RetrofitClient.getMyInstance().create(NewsRequestApi::class.java).getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter({ baseResponse -> baseResponse != null && baseResponse.articles != null })
                .subscribe({ baseResponse ->  presenter.showNewsCard(baseResponse.articles)})
    }

    @SuppressLint
    override fun saveFavouriteNews(news: News) {
        val disposable = Completable.fromAction { db.newsDao().insertNews(news) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({

        }, { error -> })
    }
}