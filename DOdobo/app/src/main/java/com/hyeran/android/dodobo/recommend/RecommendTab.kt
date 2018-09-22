package com.hyeran.android.dodobo.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recommend.Seoulightlist
import kotlinx.android.synthetic.main.fragment_category_seoulight.view.*


class RecommendTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        replaceFragment(Seoulightlist())
    }

    val bundle = Bundle()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_category_seoulight, container, false)
        v.ib_all_seoulightcategory.setOnClickListener(this)
        return v
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frame_main, fragment)
        fragmentTransaction.commit()
    }
}