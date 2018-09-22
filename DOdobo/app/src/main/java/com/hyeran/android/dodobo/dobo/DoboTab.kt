package com.hyeran.android.dodobo.dobo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

class DoboTab : Fragment() {
    lateinit var dobolistItems : ArrayList<DobolistItem>
    lateinit var dobolistAdapter : DobolistAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dobolistItems = ArrayList()
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))

        var rv_dobolist = view!!.findViewById<View>(R.id.rv_dobolist_dobo) as RecyclerView
        dobolistAdapter = DobolistAdapter(dobolistItems, context!!)
        rv_dobolist?.layoutManager = LinearLayoutManager(context!!)
        rv_dobolist?.adapter = dobolistAdapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dobo, container, false)
    }
}