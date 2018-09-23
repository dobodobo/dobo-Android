package com.hyeran.android.dodobo.recommend

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class CourseAdapter(private var courseItems: ArrayList<CourseItem>) : RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(mainView)
    }

    override fun getItemCount(): Int = courseItems.size

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.icon.setImageResource(courseItems[position].icon)
        holder.content.text = courseItems[position].content
    }
}