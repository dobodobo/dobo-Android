package com.hyeran.android.dodobo.recyclerview.review

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.hyeran.android.dodobo.R

class ReviewViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var reviewwriter : TextView = itemView!!.findViewById(R.id.tv_writer_seoulightreview) as TextView
    var reviewdate : TextView = itemView!!.findViewById(R.id.tv_date_seoulightreview) as TextView
    var reviewcontent : TextView = itemView!!.findViewById(R.id.tv_content_seoulightreview) as TextView
}