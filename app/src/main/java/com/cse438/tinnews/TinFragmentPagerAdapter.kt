package com.cse438.tinnews


import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.cse438.tinnews.common.ContainerFragment
import java.lang.IndexOutOfBoundsException

class TinFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    companion object {
        val FRAGMENT_NUMBER = 3
    }
    // three pages in total, we need an array of Fragments
    private val fragments = arrayOfNulls<Fragment>(FRAGMENT_NUMBER)
    init {
        for (i in 0..2) {
            // put all fragments into array
            fragments[i] = ContainerFragment.newInstance(i)
        }
    }



    override fun getCount(): Int {
        return FRAGMENT_NUMBER
    }

    override fun getItem(position: Int): Fragment? {
        if (position < 0 || position > FRAGMENT_NUMBER) {
            throw IndexOutOfBoundsException("Out of Boundary")
        }
        return fragments[position]
    }
}