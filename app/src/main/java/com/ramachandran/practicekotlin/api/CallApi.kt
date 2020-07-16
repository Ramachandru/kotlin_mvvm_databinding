package com.ramachandran.practicekotlin.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallApi {
    companion object{
        fun getRerofit(): Retrofit = Retrofit.Builder()
            .baseUrl(Api.BSAEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}