package com.hyeran.android.dodobo.recyclerview.mypagelist

import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class DobolistAdapter(private var dobolistItems : ArrayList<DobolistItem>, val context : Context) : RecyclerView.Adapter<DobolistViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DobolistViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_dobolist_mypage, parent, false)
        return DobolistViewHolder(mainView)
    }

    override fun getItemCount(): Int = dobolistItems.size

    override fun onBindViewHolder(holder: DobolistViewHolder, position: Int) {
        holder.doboImage.setImageResource(dobolistItems[position].image)
        holder.doboName.text = dobolistItems[position].name
    }
}