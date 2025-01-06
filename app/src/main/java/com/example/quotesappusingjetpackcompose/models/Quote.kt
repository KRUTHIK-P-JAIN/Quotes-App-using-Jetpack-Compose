package com.example.quotesappusingjetpackcompose.models

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote") val text: String,
    val author: String
)
