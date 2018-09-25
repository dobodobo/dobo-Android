package com.hyeran.android.dodobo

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.hyeran.android.dodobo.R

class ImgSlideAdapter(context : Context) : PagerAdapter() {
    var images : Array<Int> = arrayOf(R.drawable.dialog, R.drawable.ic_see_course, R.drawable.question_btn, R.drawable.individualbtn_click, R.drawable.group_click)
    lateinit var inflater : LayoutInflater
    var context : Context = context

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var v : View = inflater.inflate(R.layout.slider_img, container, false)
        var imageView : ImageView = v.findViewById(R.id.iv_sliderimg) as ImageView

        imageView.setImageResource(images[position])
        container.addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.invalidate()
    }
}