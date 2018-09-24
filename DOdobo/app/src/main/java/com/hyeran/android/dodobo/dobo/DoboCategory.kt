package com.hyeran.android.dodobo.dobo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_category_dobo.view.*

class DoboCategory : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {
        replaceFragment(Dobolist())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_category_dobo, container, false)
        v.ib_all_dobocategory.setOnClickListener(this)
        return v
    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frame_main, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}