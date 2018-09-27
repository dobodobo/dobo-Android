package com.hyeran.android.dodobo.recyclerview.seoulightlist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class SeoulightlistAdapter(private var seoulightlistItems: ArrayList<SeoulightlistItem>, val context : Context) : RecyclerView.Adapter<SeoulightlistViewHolder>() {
    private  lateinit var  onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeoulightlistViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_seoulightlist, parent, false)
        mainView.setOnClickListener(onItemClick)

        return SeoulightlistViewHolder(mainView)
    }

    override fun getItemCount(): Int = seoulightlistItems.size

    override fun onBindViewHolder(holder: SeoulightlistViewHolder, position: Int) {
        holder.seoulightImage.setImageResource(seoulightlistItems[position].image)
        holder.seoulightTitle.text = seoulightlistItems[position].title
        holder.seoulightLanguage.text = seoulightlistItems[position].language
        holder.seoulightDate.text = seoulightlistItems[position].date
        holder.seoulightMinPeople.setText(seoulightlistItems[position].minpeople)
        holder.seoulightMaxPeople.setText(seoulightlistItems[position].maxpeople)
    }
}
