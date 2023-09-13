package com.example.composepractice.screen

import com.google.gson.annotations.SerializedName

data class Quotes (

    @SerializedName("quote"  ) var quote  : String? = null,
    @SerializedName("author" ) var author : String? = null

)