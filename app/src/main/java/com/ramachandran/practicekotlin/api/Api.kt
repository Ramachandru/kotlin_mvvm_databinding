package com.ramachandran.practicekotlin.api

import com.ramachandran.practicekotlin.model.ContactDetails
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object{
        const val BSAEURL :String ="https://api.androidhive.info/"
    }
    @GET("contacts/")
    fun getContactDetails() : Call<ContactDetails>
}