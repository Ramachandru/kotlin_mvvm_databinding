package com.ramachandran.practicekotlin

import com.ramachandran.practicekotlin.model.Contacts

class ContactSingleton {
    var contactsMap =HashMap<String,List<Contacts>>()
    companion object{
        var contactSingleton : ContactSingleton?=null
        fun getInstance() : ContactSingleton{
            if(contactSingleton == null){
                synchronized(ContactSingleton::class.java){
                    if(contactSingleton == null){
                        contactSingleton = ContactSingleton()
                    }
                }
            }
            return contactSingleton!!
        }
    }
    fun set(value : HashMap<String,List<Contacts>>){
        contactsMap = value
    }
    fun get() : HashMap<String,List<Contacts>> = contactsMap
}