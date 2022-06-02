package com.zaniva.githubuserappv3.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Connection {
    private const val HOME = "https://api.github.com/"

    val rt = Retrofit.Builder()
        .baseUrl(HOME)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiIns = rt.create(Query::class.java)
}