package com.hyeran.android.dodobo.recyclerview.dobolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.Model.dobo.DoboListResult
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class DobolistAdapter(private var dobolistItems : ArrayList<DoboListResult>, var context: Context) : RecyclerView.Adapter<DobolistViewHolder>(){
    private  lateinit var  onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DobolistViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_dobolist_dobo, parent, false)
        mainView.setOnClickListener(onItemClick)
        return DobolistViewHolder(mainView)
    }

    override fun getItemCount(): Int = dobolistItems.size

    override fun onBindViewHolder(holder: DobolistViewHolder, position: Int) {
        //holder.doboImage.setImageResource(dobolistItems[position].image)
        holder.doboTitle.text = dobolistItems[position].title
        holder.doboExplain.text = dobolistItems[position].intro
    }
}