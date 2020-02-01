package com.cse438.tinnews

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.menu.MenuBuilder
import android.support.v7.view.menu.MenuPopupHelper
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import com.cse438.tinnews.R.id.menu_copy
import com.cse438.tinnews.R.id.menu_share
import com.cse438.tinnews.common.TinBasicActivity
import com.cse438.tinnews.common.TinBasicFragment
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : TinBasicActivity(), PopupMenu.OnMenuItemClickListener {

    companion object {
        val URL = "url"
    }
    lateinit var url: String
    lateinit var progressBar:ProgressBar

    @SuppressLint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set a listener for back button
        back.setOnClickListener {
            onBackPressed()
        }
        progressBar = progress_bar

        // configure webview
        val webView = web_view
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                webView.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }
        }

        val bundle = intent.extras
        if (bundle != null) {
            val innerBundle = bundle.getBundle(TinBasicActivity.BUNDLE)
            if (innerBundle != null) {
                url = innerBundle.getString(URL)
                webView.loadUrl(url)
            }
        }


        // set a listener for more button
        more.setOnClickListener {
            showMenu(it)
        }
    }

    // show menu for more button
    @SuppressLint("RestrictedApi")
    fun showMenu(view: View) {
        // create a PopupMenu object
        val menu = PopupMenu(this, view)
        val inflater = menu.menuInflater
        menu.setOnMenuItemClickListener(this)
        inflater.inflate(R.menu.web_view_items, menu.menu)
        val menuHelper = MenuPopupHelper(this, menu.menu as MenuBuilder, view)
        menuHelper.setForceShowIcon(true)
        menuHelper.show()
    }

    // set listener when clicking on menu items
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_share -> {
                val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                sharingIntent.setType("text/plain")
                var shareBody = "From TinNews: \n" + url
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Share TinNews"))
            }
            R.id.menu_copy -> {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                var clip = ClipData.newPlainText("simple text", url)
                clipboard.primaryClip = clip
                Toast.makeText(this, "Link Copied", Toast.LENGTH_LONG).show()
            }
            else -> {

            }
        }
        return true
    }

    override fun getLayout(): Int {
        return R.layout.activity_web_view
    }

    override fun showSnackBar(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doFragmentTransaction(fragment: TinBasicFragment) {

    }
}
