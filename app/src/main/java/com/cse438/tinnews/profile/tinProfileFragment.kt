package com.cse438.tinnews.profile


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cse438.tinnews.MainActivity

import com.cse438.tinnews.R
import com.cse438.tinnews.TinApplication
import com.cse438.tinnews.database.AppDatabase
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_tin_profile.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class tinProfileFragment : Fragment() {


    private var db = TinApplication.database

    companion object {
        fun newInstance(): tinProfileFragment {

            val args = Bundle()

            val fragment = tinProfileFragment()
            fragment.setArguments(args)
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tin_profile, container, false)
        var clearButton = view.findViewById<View>(R.id.clear_btn)
        clearButton!!.setOnClickListener {
            deleteAllNewsCache()
        }
        return view
    }

//    @SuppressLint("CheckResult")
//    @Override
//    public void deleteAllNewsCache() {
//        Disposable disposable = Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
//            presenter.onCacheCleared();
//        }, error -> {
//
//        });

    @SuppressLint("CheckResult")
    fun deleteAllNewsCache() {
        val disposable = Completable.fromAction{db.newsDao().deleteAllNews()}
        disposable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {

                }, { error -> }
        )
        Toast.makeText(context, "Cache Cleared!", Toast.LENGTH_LONG).show()
    }







    }


