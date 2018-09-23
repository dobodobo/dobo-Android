package com.hyeran.android.dodobo.recyclerview.surrounding

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hyeran.android.dodobo.R

class SurroundingViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var image : ImageView = itemView!!.findViewById(R.id.iv_image_surrounding) as ImageView
    var title : TextView = itemView!!.findViewById(R.id.tv_title_surrounding) as TextView
    var icon : ImageView = itemView!!.findViewById(R.id.iv_icon_surrounding) as ImageView
    var category : TextView = itemView!!.findViewById(R.id.tv_category_surrounding) as TextView
}