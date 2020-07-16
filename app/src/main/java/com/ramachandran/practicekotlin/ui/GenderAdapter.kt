package com.ramachandran.practicekotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.practicekotlin.OnDataListeners
import com.ramachandran.practicekotlin.databinding.GenderadapterBinding


class GenderAdapter(context : Context) : RecyclerView.Adapter<GenderAdapter.GenderViewHolder>() {
    val mContext : Context?= context
    var onDataListen : OnDataListeners?=null
    init{
        onDataListen=mContext as OnDataListeners
    }
    var dataList : List<String>? =null;
    fun setValue(list : List<String>){
        dataList=list;
    }
    lateinit var genderadapterBinding : GenderadapterBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenderViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        genderadapterBinding = GenderadapterBinding.inflate(layoutInflater,parent,false)
        return GenderViewHolder(genderadapterBinding,mContext!!)
    }
    fun OnClicked( gender  :String ){
        onDataListen?.onData(gender)
    }
    override fun getItemCount(): Int =dataList!!.size

    override fun onBindViewHolder(holder: GenderViewHolder, position: Int) {
        val genderN=dataList?.get(position);
        holder.showValue(genderN!!)
    }
    class GenderViewHolder(itemView: GenderadapterBinding,context : Context) : RecyclerView.ViewHolder(itemView.root) {
        val genderBinding : GenderadapterBinding = itemView;
        val cont : Context = context
        fun showValue(gendername : String){
            genderBinding.genderName=gendername
            genderBinding.click=GenderAdapter(cont)
            genderBinding.executePendingBindings()
        }
    }

}