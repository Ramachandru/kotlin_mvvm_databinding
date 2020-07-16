package com.ramachandran.practicekotlin.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.practicekotlin.ContactSingleton
import com.ramachandran.practicekotlin.OnDataListeners
import com.ramachandran.practicekotlin.R
import com.ramachandran.practicekotlin.viewmodel.ContactViewModel

class MainActivity : AppCompatActivity(),OnDataListeners {
    override fun onData(name: String) {
        val lIndent= Intent(this@MainActivity,ContactActivity::class.java)
        lIndent.putExtra("contact",name)
        startActivity(lIndent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyle=findViewById(R.id.recycle) as RecyclerView
        val linearLayoutManager =LinearLayoutManager(this@MainActivity)
        recyle.layoutManager=linearLayoutManager
        var genderadapter =GenderAdapter(this@MainActivity)
        genderadapter.setValue(mutableListOf())
        recyle.adapter=genderadapter
        val contactViewModel= ViewModelProviders.of(this).get(ContactViewModel::class.java)
        contactViewModel.getAllContacts()?.observe(this,Observer{
            ContactSingleton.getInstance().set(it)
            genderadapter.setValue(ArrayList<String>(it.keys))
            genderadapter.notifyDataSetChanged()
        })
    }
}
