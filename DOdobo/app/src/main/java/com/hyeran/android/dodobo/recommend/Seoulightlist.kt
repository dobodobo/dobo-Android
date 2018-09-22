package com.hyeran.android.dodobo.recommend

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_recommend.*
import kotlinx.android.synthetic.main.fragment_recommend.view.*

class Seoulightlist : Fragment() {
    lateinit var seoulightlistItems : ArrayList<SeoulightlistItem>
    lateinit var seoulightlistAdapter : SeoulightlistAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seoulightlistItems = ArrayList()
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))
        seoulightlistItems.add(SeoulightlistItem(R.drawable.home, "여기는 타이틀", "일본어", "2018.09.22", "3-5 명"))


        var rv_seoulightlist = view!!.findViewById<View>(R.id.rv_seoulightlist_recommend) as RecyclerView
        seoulightlistAdapter = SeoulightlistAdapter(seoulightlistItems, context!!)
        rv_seoulightlist?.layoutManager = LinearLayoutManager(context!!)
        rv_seoulightlist?.adapter = seoulightlistAdapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v =  inflater.inflate(R.layout.fragment_recommend, container, false)
        v.tv_popularity_recommend.setOnClickListener {
            tv_popularity_recommend.setTextColor(Color.parseColor("#434343"))
            tv_deadline_recommend.setTextColor(Color.parseColor("#c4c4c4"))
        }
        v.tv_deadline_recommend.setOnClickListener {
            tv_deadline_recommend.setTextColor(Color.parseColor("#434343"))
            tv_popularity_recommend.setTextColor(Color.parseColor("#c4c4c4"))
        }
        return v
    }

}