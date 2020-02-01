package com.cse438.tinnews.save;

import com.cse438.tinnews.mvp.MVPContract;
import com.cse438.tinnews.retrofit.response.News;

import java.util.List;

public interface SavedNewsContract {
    interface View extends MVPContract.View<Presenter> {
        void loadSavedNews(List<News> newsList);
    }

    interface Presenter extends  MVPContract.Presenter<View, Model> {
        void loadSavedNews(List<News> newsList);
    }

    interface Model extends MVPContract.Model<Presenter> {
        void fetchData();
    }

}
