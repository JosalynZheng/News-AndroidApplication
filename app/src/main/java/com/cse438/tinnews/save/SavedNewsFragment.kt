package com.cse438.tinnews.save

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.cse438.tinnews.R
import com.cse438.tinnews.mvp.MVPFragment
import com.cse438.tinnews.retrofit.response.News
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cse438.tinnews.common.ViewModelAdapter
import java.util.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SavedNewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SavedNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SavedNewsFragment : MVPFragment<SavedNewsContract.Presenter>(), SavedNewsContract.View {

    companion object {
        fun newInstance(): SavedNewsFragment {
            val args = Bundle()
            val fragment = SavedNewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var author: TextView
    private lateinit var description: TextView

    private lateinit var savedNewsAdapter: ViewModelAdapter
    private lateinit var emptyState: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_saved_news, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        emptyState = view.findViewById(R.id.empty_state)
        savedNewsAdapter = ViewModelAdapter()
        recyclerView.adapter = savedNewsAdapter
        return view

    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }


    override fun getPresenter(): SavedNewsContract.Presenter {
        return SavedNewsPresenter()
    }

    override fun loadSavedNews(newsList: MutableList<News>) {
        if (newsList.size === 0) {
            emptyState.visibility = View.VISIBLE
        } else {
            emptyState.visibility = View.GONE
        }
        if (newsList != null) {
            val models = LinkedList<SavedNewsViewModel>()
            for (news in newsList) {
                models.add(SavedNewsViewModel(news, tinFragmentManager))
            }
            savedNewsAdapter.addViewModels(models)
        }
    }

}
