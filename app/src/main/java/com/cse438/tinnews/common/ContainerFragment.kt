package com.cse438.tinnews.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cse438.tinnews.R
import com.cse438.tinnews.R.id.*
import com.cse438.tinnews.profile.tinProfileFragment
import com.cse438.tinnews.save.SavedNewsFragment
import com.cse438.tinnews.tin.TinGalleryFragment
import kotlinx.android.synthetic.main.fragment_tin_basic.*
import java.lang.IndexOutOfBoundsException

class ContainerFragment: TinBasicFragment() {
    private var pageIndex = 0
    private var initFragment: Fragment? = null

    companion object {
        // define container index and tag
        val HOME_PAGE = 0
        val HOME_PAGE_TAG = "home_page"
        val SAVE_PAGE = 1
        val SAVE_PAGE_TAG = "save_page"
        val PROFILE_PAGE = 2
        val PROFILE_PAGE_TAG = "profile_page"

        fun newInstance(pageIndex: Int): ContainerFragment {
            val containerFragment = ContainerFragment()
            containerFragment.pageIndex = pageIndex
            containerFragment.initFragment = createInitFragmentByIndex(pageIndex)
            return containerFragment
        }

        fun getPositionById(id: Int): Int {
            when (id) {
                action_tin -> {
                    return HOME_PAGE
                }
                action_save -> {
                    return SAVE_PAGE
                }
                action_profile -> {
                    return PROFILE_PAGE
                }
                else -> {
                    throw IndexOutOfBoundsException()
                }
            }
        }

        fun createInitFragmentByIndex(pageIndex: Int): Fragment? {
            when(pageIndex) {
                HOME_PAGE -> {
                    return TinGalleryFragment.newInstance()
                }
                SAVE_PAGE -> {
                    return SavedNewsFragment.newInstance()
                }
                PROFILE_PAGE -> {
                    return tinProfileFragment.newInstance()
                }
                else -> {
                    throw IndexOutOfBoundsException()
                }
            }
        }

        fun getCurrentTag(position: Int): String? {
            when(position) {
                HOME_PAGE -> return HOME_PAGE_TAG
                SAVE_PAGE -> return SAVE_PAGE_TAG
                PROFILE_PAGE -> return PROFILE_PAGE_TAG
                else -> return null
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.child_fragment_container, container, false)
    }

    // attach childFragment to the ContainerFragment when activity get created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (initFragment != null && !(initFragment as Fragment).isAdded) {
            childFragmentManager.beginTransaction().replace(R.id.child_fragment_container, initFragment, getCurrentTag(pageIndex)).commit()
        }
    }


}