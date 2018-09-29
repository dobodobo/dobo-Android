package com.hyeran.android.dodobo.recyclerview.courseenroll_image

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.hyeran.android.dodobo.R

class CourseImgViewHolder (itemView: View?) :RecyclerView.ViewHolder(itemView){
    var image : ImageView = itemView!!.findViewById(R.id.iv_photo_courseenrollitem) as ImageView
}