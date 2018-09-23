package com.hyeran.android.dodobo.recyclerview.dobolist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hyeran.android.dodobo.R
import org.w3c.dom.Text

class DobolistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var doboImage : ImageView = itemView!!.findViewById(R.id.iv_image_dobo) as ImageView
    var doboTitle : TextView = itemView!!.findViewById(R.id.tv_title_dobo) as TextView
    var doboExplain : TextView = itemView!!.findViewById(R.id.tv_explain_dobo) as TextView
}