package com.example.jsoup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    lateinit var newsListView:ListView
    var newsList = mutableListOf<newData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsListView=findViewById(R.id.newsListView)

        val arrayAdapter = MyListAdapter(this,newsList)
        newsListView.adapter = arrayAdapter

        val result = Result()
        val run= Runnable {
            val lists =result.news()
            Log.d("result","başladı")

            runOnUiThread {

                for(list in lists){
                    newsList.add(list)
                }

                arrayAdapter.notifyDataSetChanged()

            }
        }

        Thread(run).start()

        newsListView.setOnItemClickListener { adapterView, view, i, l ->
            intent = Intent(this, DetailPage::class.java)
            val href=newsList.get(i).href
            intent.putExtra("href",href )
            startActivity(intent)
        }
    }
}