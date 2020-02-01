package com.cse438.tinnews.tin;

import com.cse438.tinnews.mvp.MVPContract;
import com.cse438.tinnews.retrofit.response.News;

import java.util.List;

public interface TinContract {


    interface View extends MVPContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
    }

    interface Presenter extends MVPContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavouriteNews(News news);
    }

    interface Model extends MVPContract.Model<Presenter> {
        void fetchData();
        void saveFavouriteNews(News news);
    }
}

