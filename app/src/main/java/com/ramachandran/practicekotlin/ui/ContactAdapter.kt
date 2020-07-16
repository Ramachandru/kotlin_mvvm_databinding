package com.ramachandran.practicekotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.practicekotlin.databinding.ContactadapterBinding
import com.ramachandran.practicekotlin.model.Contacts

class ContactAdapter :RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    lateinit var contactadapterBinding: ContactadapterBinding
    var mContactList  :List<Contacts>? =null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        contactadapterBinding = ContactadapterBinding.inflate(layoutInflater,parent,false)
        return ContactViewHolder(contactadapterBinding)
    }
    fun setList(contactList : List<Contacts>) : Unit{
        mContactList=contactList
    }
    override fun getItemCount(): Int = mContactList!!.size
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = mContactList!!.get(position)
        holder.populateView(contact)
    }
    class ContactViewHolder(binding : ContactadapterBinding) : RecyclerView.ViewHolder(binding.root){
       val contactBinding : ContactadapterBinding= binding
        fun populateView(contacts : Contacts){
            contactBinding.contact = contacts
            contactBinding.executePendingBindings()
        }
    }

}