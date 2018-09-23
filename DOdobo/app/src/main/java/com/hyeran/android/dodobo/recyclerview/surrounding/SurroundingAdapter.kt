package com.hyeran.android.dodobo.recyclerview.surrounding

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class SurroundingAdapter(private var surroundingItems: ArrayList<SurroundingItem>) : RecyclerView.Adapter<SurroundingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurroundingViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_surrounding, parent, false)
        return SurroundingViewHolder(mainView)
    }

    override fun getItemCount(): Int = surroundingItems.size

    override fun onBindViewHolder(holder: SurroundingViewHolder, position: Int) {
        holder.image.setImageResource(surroundingItems[position].image)
        holder.title.text = surroundingItems[position].title
        holder.icon.setImageResource(surroundingItems[position].icon)
        holder.category.text = surroundingItems[position].category
    }
}
