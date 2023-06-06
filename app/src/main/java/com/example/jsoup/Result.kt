package com.example.jsoup



import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Result {
    fun news():MutableList<newData>{
        var array = mutableListOf<newData>()
        val uri="https://www.haberler.com"
        val doc:Document=Jsoup.connect(uri).timeout(15000).get()
        val elements:Elements=doc.getElementsByAttribute("data-headlinenumber")
        for(element in elements){
            var item=element.attr("abs:href")
            val elementInside=element.getElementsByTag("img")
            val dataSrc=elementInside.attr("data-src")
            val title=elementInside.attr("alt")
            if(dataSrc!=""&&item!=""&&title!=""){
                val new= newData(title,dataSrc,item)
                array.add(new)
            }


        }
        return array
    }
}