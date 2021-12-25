package com.ramachandran.practicekotlin.model

data class ContactDetails(val contacts : ArrayList<Contacts>)
data class Contacts(val id: String,
                    val name : String,
                    val email : String,
                    val address : String,
                    val gender : String,
                    val phone : Phone)
data class Phone(val mobile : String,val feature: String,var age: String)



