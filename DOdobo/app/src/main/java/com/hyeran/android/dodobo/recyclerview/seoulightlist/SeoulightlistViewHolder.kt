package com.hyeran.android.dodobo.recyclerview.seoulightlist

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
    var seoulightMinPeople : TextView = itemView!!.findViewById(R.id.tv_minpeople_seoulight)
    var seoulightMaxPeople : TextView = itemView!!.findViewById(R.id.tv_maxpeople_seoulight)
}