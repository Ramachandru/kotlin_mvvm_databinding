package com.ramachandran.practicekotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramachandran.practicekotlin.api.Api
import com.ramachandran.practicekotlin.api.CallApi
import com.ramachandran.practicekotlin.model.ContactDetails
import com.ramachandran.practicekotlin.model.Contacts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactViewModel : ViewModel(){
    private var mutableLiveData : MutableLiveData<HashMap<String,List<Contacts>>>?= MutableLiveData<HashMap<String,List<Contacts>>>()
    fun getAllContacts() : MutableLiveData<HashMap<String,List<Contacts>>>? {
        getContact()
        return mutableLiveData
    }
    fun getContact() : Unit{
        var api=CallApi.getRerofit().create(Api::class.java)
        val callData :Call<ContactDetails> =api.getContactDetails()
        callData.enqueue(object : Callback<ContactDetails>{
            override fun onFailure(call: Call<ContactDetails>, t: Throwable) {
                Log.v("","Error "+t.message)
            }
            override fun onResponse(call: Call<ContactDetails>, response: Response<ContactDetails>) {
                mutableLiveData?.value = setAllContacts(response.body()!!)
            }

        })
    }
    fun setAllContacts(contactDetails: ContactDetails) : HashMap<String,List<Contacts>>{
        val maps=HashMap<String,List<Contacts>>()
        for(contact in contactDetails.contacts){
            setContactValue(maps,contact)
        }
        return maps
    }
    fun setContactValue(maps : HashMap<String,List<Contacts>>,contact : Contacts) : Unit{
        if(maps.containsKey(contact.gender)){
           val list: ArrayList<Contacts>? = maps.get(contact.gender) as ArrayList
            list!!.add(contact)
            maps.put(contact.gender,list)
        }
        else{
            val list = ArrayList<Contacts>()
            list.add(contact)
            maps.put(contact.gender,list)
        }
    }
}