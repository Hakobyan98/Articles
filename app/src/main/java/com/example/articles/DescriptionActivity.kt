package com.example.articles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.article_description.*

class DescriptionActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.article_description)
        val link = intent.getStringExtra(CustomViewHolder.description_link)

        webview_desc.loadUrl(link)
        webview_desc.settings.javaScriptEnabled = true
        webview_desc.settings.loadWithOverviewMode = true
        webview_desc.settings.useWideViewPort = true
    }
}