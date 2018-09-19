package com.hyeran.android.dodobo.mypage

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hyeran.android.dodobo.R

class DobolistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var doboImage : ImageView = itemView!!.findViewById(R.id.iv_listimage_dobolist) as ImageView
    var doboName : TextView = itemView!!.findViewById(R.id.tv_listname_dobolist) as TextView
}