package com.hyeran.android.dodobo.recommend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.hyeran.android.dodobo.R

class CourseSpinnerAdapter(context: Context, list: ArrayList<CourseSpinner>) : BaseAdapter() {

    var _context : Context = context
    var _list : ArrayList<CourseSpinner> = list
    var view : View? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        view = convertView

        if(view == null) {
            var inflater : LayoutInflater = _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false)
        }
        var icon : CourseSpinner = _list.get(position)

        var imgView : ImageView = view?.findViewById(R.id.iv_spinneritem) as ImageView
        imgView.setImageResource(icon.getIcon())
        return view
    }

    override fun getItem(position: Int): Any {
        return _list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int = _list.size
}