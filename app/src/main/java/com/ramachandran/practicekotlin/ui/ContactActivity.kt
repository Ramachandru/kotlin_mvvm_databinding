package com.ramachandran.practicekotlin.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.practicekotlin.ContactSingleton
import com.ramachandran.practicekotlin.R

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactactivity)
        val keyValue=intent.getStringExtra("contact")
        val contactList= ContactSingleton.getInstance().get().get(keyValue)
        val contactRecycle=findViewById(R.id.contactRecycle) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(this@ContactActivity)
        val contactAdapter = ContactAdapter()
        contactAdapter.setList(contactList!!)
        contactRecycle.layoutManager=linearLayoutManager
        contactRecycle.adapter=contactAdapter
    }
}