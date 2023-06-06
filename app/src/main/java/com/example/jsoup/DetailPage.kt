package com.example.jsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView

class DetailPage : AppCompatActivity() {
    lateinit var newsDetail:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        val href:String = intent.getStringExtra("href").toString()
        Log.d("href",href)
        newsDetail=findViewById(R.id.newsDetail)
        newsDetail.settings.javaScriptEnabled=true
        newsDetail.loadUrl(href)

    }
}