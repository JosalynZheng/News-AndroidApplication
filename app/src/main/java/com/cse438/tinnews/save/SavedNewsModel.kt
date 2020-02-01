package com.cse438.tinnews.save

import android.annotation.SuppressLint
import com.cse438.tinnews.TinApplication
import com.cse438.tinnews.database.AppDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SavedNewsModel : SavedNewsContract.Model {
    private lateinit var presenter : SavedNewsContract.Presenter
    private lateinit var db : AppDatabase

    override fun setPresenter(presenter: SavedNewsContract.Presenter) {
        this.presenter = presenter
    }

    init {
        db = TinApplication.database
    }

    @SuppressLint("CheckResult")
    override fun fetchData() {
//        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(presenter::loadSavedNews, error -> {
//            System.out.println("error");
//        }, () -> {
//            System.out.println("complete");
//        });
        db.newsDao().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(presenter::loadSavedNews,{System.out.println("error")}, {System.out.println("complete")})

    }

}