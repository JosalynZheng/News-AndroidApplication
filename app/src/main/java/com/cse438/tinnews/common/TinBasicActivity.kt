package com.cse438.tinnews.common

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class TinBasicActivity: AppCompatActivity(), TinFragmentManager {
    companion object {
        val BUNDLE = "bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    override fun startActivityWithBundle(clazz: Class<*>, isFinished: Boolean, bundle: Bundle) {
        val intent = Intent(this, clazz)
        intent.putExtra(BUNDLE, bundle)
        startActivity(intent)
        if (isFinished) {
            finish()
        }
    }

    @LayoutRes
    abstract fun getLayout(): Int
}