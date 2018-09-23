package com.hyeran.android.dodobo.recommend

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.hyeran.android.dodobo.R

class LanguageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var language : TextView = itemView!!.findViewById(R.id.tv_language_seoulightdetail) as TextView
}