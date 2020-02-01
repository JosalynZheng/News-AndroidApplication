package com.cse438.tinnews.common

import android.app.Fragment
import android.os.Bundle

interface TinFragmentManager {
    fun startActivityWithBundle(clazz: Class<*>, isFinished: Boolean, bundle: Bundle)

    fun showSnackBar(message: String)

    fun doFragmentTransaction(fragment: TinBasicFragment)
}