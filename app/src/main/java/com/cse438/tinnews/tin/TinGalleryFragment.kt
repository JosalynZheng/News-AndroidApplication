package com.cse438.tinnews.tin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cse438.tinnews.R
import com.cse438.tinnews.common.TinBasicFragment
import com.cse438.tinnews.mvp.MVPFragment
import com.cse438.tinnews.retrofit.NewsRequestApi
import com.cse438.tinnews.retrofit.RetrofitClient
import com.cse438.tinnews.retrofit.response.News
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.SwipeViewBuilder
import kotlinx.android.synthetic.main.fragment_tin_gallery.view.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers







// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TinGalleryFragment : MVPFragment<TinContract.Presenter>(), TinNewsCard.OnSwipeListener, TinContract.View {

    private lateinit var mSwipeView: SwipePlaceHolderView

    companion object {
        fun newInstance(): TinGalleryFragment {
            val args = Bundle()
            val fragment = TinGalleryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getPresenter(): TinContract.Presenter {
        return TinPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tin_gallery, container, false)
        mSwipeView = view.findViewById(R.id.swipeView)
        mSwipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
                .setDisplayViewCount(3)
                .setSwipeDecor(SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tin_news_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tin_news_swipe_out_msg_view))

        view.rejectBtn.setOnClickListener {
            mSwipeView.doSwipe(false)
        }
        view.acceptBtn.setOnClickListener {
            mSwipeView.doSwipe(true)
        }


        return view
    }


    override fun onLike(news: News) {
        presenter.saveFavouriteNews(news)
    }

//    fun getData() {
//        RetrofitClient.getMyInstance().create(NewsRequestApi::class.java).getNewsByCountry("us")
//                .subscribeOn
//    }


    override fun showNewsCard(newsList: List<News>) {
        for (news in newsList) {
            val tinNewsCard = TinNewsCard(news, mSwipeView, this)
            mSwipeView.addView(tinNewsCard)
        }
    }

}
