package com.example.quotesappusingjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesappusingjetpackcompose.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")

        //read the input stream in bytes
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        //convert the file read to string format
        val json = String(buffer, Charsets.UTF_8)

        //used to convert json to kotlin/java objects
        val gson = Gson()

        //provides array of Quote
        data = gson.fromJson(json, Array<Quote>::class.java)

        isDataLoaded.value = true
    }
}