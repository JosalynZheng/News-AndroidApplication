package com.cse438.tinnews.save


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cse438.tinnews.MainActivity

import com.cse438.tinnews.R
import com.cse438.tinnews.WebViewActivity
import com.cse438.tinnews.common.TinBasicFragment
import com.cse438.tinnews.common.ViewModelAdapter
import com.cse438.tinnews.retrofit.response.News
import kotlinx.android.synthetic.main.fragment_saved_news.*
import kotlinx.android.synthetic.main.fragment_saved_news_detailed.*
import kotlinx.android.synthetic.main.fragment_saved_news_detailed.view.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cse438.tinnews.common.BaseViewModel
import com.cse438.tinnews.common.Util
import java.util.*



// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SavedNewsDetailedFragment : TinBasicFragment() {


    private lateinit var viewModelAdapter: ViewModelAdapter

    companion object {

        val NEWS = "news"

        fun newInstance(news: News): SavedNewsDetailedFragment {
            val args = Bundle()
            args.putSerializable(NEWS, news)
            val fragment = SavedNewsDetailedFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_saved_news_detailed, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModelAdapter = ViewModelAdapter()
        recyclerView.adapter = viewModelAdapter
        return view
    }


    override fun onResume() {
        super.onResume()
        loadNews(arguments.getSerializable(NEWS) as News)
    }

    fun loadNews(news: News) {
        val viewModels = LinkedList<BaseViewModel<*>>()

        if (!Util.isStringEmpty(news.title)) {
            viewModels.add(TitleViewModel(news.title));
        }


        if (!Util.isStringEmpty(news.author) || !Util.isStringEmpty(news.time)) {
            viewModels.add(AuthorViewModel(news.author, news.time))
        }


        if (!Util.isStringEmpty((news.image))) {
            viewModels.add(ImageViewModel(news.image));
        }

        if (!Util.isStringEmpty(news.description)) {
            viewModels.add(DescriptionViewModel(news.description));
        }

        if (!Util.isStringEmpty(news.url)) {
            viewModels.add(ReadmoreViewModel(news.url, tinFragmentManager))
        }


        viewModelAdapter.addViewModels(viewModels)




    }

}
