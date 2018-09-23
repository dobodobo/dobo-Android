package com.hyeran.android.dodobo.recommend

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hyeran.android.dodobo.R

class CourseViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var icon : ImageView = itemView!!.findViewById(R.id.iv_icon_courseitem) as ImageView
    var content : TextView = itemView!!.findViewById(R.id.tv_content_courseitem) as TextView
}