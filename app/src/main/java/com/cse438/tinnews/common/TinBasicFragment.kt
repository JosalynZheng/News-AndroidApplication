package com.cse438.tinnews.common

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cse438.tinnews.R
import java.util.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TinBasicFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TinBasicFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
open class TinBasicFragment : Fragment() {

    protected lateinit var tinFragmentManager: TinFragmentManager
    private val uuid = UUID.randomUUID().toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tin_basic, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        tinFragmentManager = context as TinFragmentManager
    }

    fun getFragmentTag(): String {
        return this.javaClass.name + uuid
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

}
