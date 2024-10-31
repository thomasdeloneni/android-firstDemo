package com.example.mod7demo1.bo

import com.squareup.moshi.Json

data class Joke(
    val id : String,
    val value: String,
    @Json(name = "icon_url")
    val iconUrl: String
)