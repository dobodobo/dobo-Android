package com.hyeran.android.dodobo.dobo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_category_dobo.*
import kotlinx.android.synthetic.main.fragment_category_dobo.view.*

class DoboCategory : Fragment(), View.OnClickListener{

    var bundle = Bundle()
    override fun onClick(v: View?) {
        when(v) {
            ib_all_dobocategory -> {
                bundle.putInt("category", 0)
            }
            ib_candicaped_dobocategory -> {
                bundle.putInt("category", 1)
            }
            ib_cityhall_dobocategory -> {
                bundle.putInt("category", 2)
            }
            ib_lake_dobocategory -> {
                bundle.putInt("category", 3)
            }
            ib_seoullo_dobocategory -> {
                bundle.putInt("category", 4)
            }
            ib_historicsite_dobocategory -> {
                bundle.putInt("category", 5)
            }
            ib_pilgrimage_dobocategory -> {
                bundle.putInt("category", 6)
            }
            ib_etc_dobocategory -> {
                bundle.putInt("category", 7)
            }
        }
        replaceFragment(Dobolist())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_category_dobo, container, false)
        v.ib_all_dobocategory.setOnClickListener(this)
        v.ib_candicaped_dobocategory.setOnClickListener(this)
        v.ib_cityhall_dobocategory.setOnClickListener(this)
        v.ib_etc_dobocategory.setOnClickListener(this)
        v.ib_historicsite_dobocategory.setOnClickListener(this)
        v.ib_lake_dobocategory.setOnClickListener(this)
        v.ib_pilgrimage_dobocategory.setOnClickListener(this)
        v.ib_seoullo_dobocategory.setOnClickListener(this)
        return v
    }
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = fragmentManager!!.beginTransaction()
        val frg = Dobolist()
        frg.arguments =  bundle
        fragmentManager.replace(R.id.frame_main, frg)
//        fragmentTransaction.addToBackStack(null)
        fragmentManager.commit()
    }
}