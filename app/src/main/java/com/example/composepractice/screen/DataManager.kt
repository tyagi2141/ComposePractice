package com.example.composepractice.screen

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

object DataManager {


    var isDataLoaded = mutableStateOf(false)

    var currentPage = mutableStateOf(Page.LISTING)

    var currentQuotes: Quotes?= null

    fun loadJSONFromAsset(context: Context): JSONArray {
        val json: String?

        val inputStream = context.assets.open("quotes.json")

        val size = inputStream.available()
        val buffer = ByteArray(size)
        val charset: Charset = Charsets.UTF_8
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, charset)

        val obj = JSONObject(json)
        val userArray = obj.getJSONArray("quotes")

        isDataLoaded.value = true

        return userArray
    }








    fun quotesList(jsonArrayData: JSONArray): MutableList<Quotes> {
        val list: MutableList<Quotes> = mutableListOf()
        list.clear()
        for (i in 0 until jsonArrayData.length()) {
            val jsonObject = jsonArrayData.getJSONObject(i)
            list.add(
                Quotes(
                    jsonObject.getString("quote"),
                    jsonObject.getString("author")
                )
            )
        }

        return list
    }


    fun switchPages(quotes: Quotes?) {
        if (currentPage.value == Page.LISTING) {
            currentQuotes = quotes
            currentPage.value = Page.DETAIL
        } else {
            currentPage.value = Page.LISTING
        }
    }


    enum class Page {
        LISTING, DETAIL
    }
}