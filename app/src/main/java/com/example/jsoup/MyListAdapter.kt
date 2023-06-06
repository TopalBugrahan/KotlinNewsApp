package com.example.jsoup

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MyListAdapter(private val context: Activity, private val newsList:MutableList<newData>)
    : ArrayAdapter<newData>(context, R.layout.costum_list_view, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val costumeList=context.layoutInflater.inflate(R.layout.costum_list_view,null)
        val imageView=costumeList.findViewById<ImageView>(R.id.imageView)
        val textView = costumeList.findViewById<TextView>(R.id.textView)

        val imageUrl = newsList.get(position).image
        val title=newsList.get(position).title
        Glide.with(context)
            .load(imageUrl)
            .override(150, 100)
            .centerCrop()
            .into(imageView)
        textView.text=title
        return costumeList
    }

}