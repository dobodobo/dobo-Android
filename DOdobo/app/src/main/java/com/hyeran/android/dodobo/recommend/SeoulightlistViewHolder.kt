package com.hyeran.android.dodobo.recommend

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hyeran.android.dodobo.R

class SeoulightlistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var seoulightImage : ImageView = itemView!!.findViewById(R.id.iv_image_seoulight)
    var seoulightTitle : TextView = itemView!!.findViewById(R.id.tv_title_seoulight)
    var seoulightLanguage : TextView = itemView!!.findViewById(R.id.tv_language_seoulight)
    var seoulightDate : TextView = itemView!!.findViewById(R.id.tv_date_seoulight)
    var seoulightPeople : TextView = itemView!!.findViewById(R.id.tv_people_seoulight)
}