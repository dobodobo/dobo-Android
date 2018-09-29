package com.hyeran.android.dodobo.recyclerview.review

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hyeran.android.dodobo.NotifyReviewDialog
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recommend.SeoulightDetailActivity
import kotlinx.android.synthetic.main.item_review.view.*

// DataClass와 ViewHolder 연결
class ReviewAdapter(private var reviewItems: ArrayList<ReviewItem>) : RecyclerView.Adapter<ReviewViewHolder>(){
    private  lateinit var  onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        mainView.setOnClickListener(onItemClick)

        mainView.btn_notify_review.setOnClickListener {
        }
        return ReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = reviewItems.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.reviewwriter.text = reviewItems[position].writer
        holder.reviewdate.text = reviewItems[position].date
        holder.reviewcontent.text = reviewItems[position].content
    }


}
