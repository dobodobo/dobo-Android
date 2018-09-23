package com.hyeran.android.dodobo.recommend

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class ReviewAdapter(private var reviewItems: ArrayList<ReviewItem>) : RecyclerView.Adapter<ReviewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = reviewItems.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.reviewwriter.text = reviewItems[position].writer
        holder.reviewdate.text = reviewItems[position].date
        holder.reviewcontent.text = reviewItems[position].content
    }
}
