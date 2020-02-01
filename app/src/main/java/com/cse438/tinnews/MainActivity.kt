package com.cse438.tinnews

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import com.cse438.tinnews.common.ContainerFragment
import com.cse438.tinnews.common.TinBasicActivity
import com.cse438.tinnews.common.TinBasicFragment
import kotlinx.android.synthetic.main.activity_main.*



// API key: d9024873f3a84a9db5e28b0ace2db36b

class MainActivity : TinBasicActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var bottomBar: BottomNavigationView
    private lateinit var adapter: TinFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // link viewPager with PagerAdapter
        adapter = TinFragmentPagerAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = TinFragmentPagerAdapter.FRAGMENT_NUMBER

        // link bottomBar with pager and its adapter
        bottomBar = bottom_navigation
        bottomBar.setOnNavigationItemSelectedListener(MyBottomBarListener())
    }

    override fun onBackPressed() {
        val fragmentManager = getCurrentChildFragmentManager()
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun showSnackBar(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getCurrentChildFragmentManager(): FragmentManager {
        return adapter.getItem(viewPager.currentItem)!!.childFragmentManager
    }

    override fun doFragmentTransaction(fragment: TinBasicFragment) {
        var fragmentTransaction = getCurrentChildFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.child_fragment_container, fragment, fragment.getFragmentTag()).addToBackStack(null).commit()
    }

    inner class MyBottomBarListener: BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            viewPager.setCurrentItem(ContainerFragment.getPositionById(item.itemId))
            return true
        }
    }
}
