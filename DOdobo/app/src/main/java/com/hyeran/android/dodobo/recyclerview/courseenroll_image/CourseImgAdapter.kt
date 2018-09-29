package com.hyeran.android.dodobo.recyclerview.courseenroll_image

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recyclerview.course.CourseViewHolder

class CourseImgAdapter(private var courseImgItems: ArrayList<CourseImgItem>) : RecyclerView.Adapter<CourseImgViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseImgViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_image_courseenroll, parent, false)
        return CourseImgViewHolder(mainView)
    }

    override fun getItemCount(): Int = courseImgItems.size

    override fun onBindViewHolder(holder: CourseImgViewHolder, position: Int) {
        holder.image.setImageResource(courseImgItems[position].image)
    }

}