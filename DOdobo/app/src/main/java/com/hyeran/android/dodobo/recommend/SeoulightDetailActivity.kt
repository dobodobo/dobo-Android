package com.hyeran.android.dodobo.recommend

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.hyeran.android.dodobo.AddReviewDialog
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recyclerview.course.CourseAdapter
import com.hyeran.android.dodobo.recyclerview.course.CourseItem
import com.hyeran.android.dodobo.recyclerview.language.LanguageAdapter
import com.hyeran.android.dodobo.recyclerview.language.LanguageItem
import com.hyeran.android.dodobo.recyclerview.review.ReviewAdapter
import com.hyeran.android.dodobo.recyclerview.review.ReviewItem
import kotlinx.android.synthetic.main.activity_seoulight_detail.*

class SeoulightDetailActivity : AppCompatActivity(){

    lateinit var  languageItems : ArrayList<LanguageItem>
    lateinit var languageAdapter : LanguageAdapter

    lateinit var courseItems : ArrayList<CourseItem>
    lateinit var courseAdapter : CourseAdapter

    lateinit var  reviewItems : ArrayList<ReviewItem>
    lateinit var  reviewAdapter : ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seoulight_detail)
        btn_back_seoulightdetail.setOnClickListener {
            finish()
        }
        btn_addreview_seoulight.setOnClickListener {
            AddReviewDialog(this).show()
        }

        // 언어 리사이클러뷰
        languageItems = ArrayList()
        languageItems.add(LanguageItem("한국어"))
        languageItems.add(LanguageItem("영어"))
        languageItems.add(LanguageItem("포르투갈어"))

        languageAdapter = LanguageAdapter(languageItems)
        rv_language_seoulightdetail.layoutManager = LinearLayoutManager(this)
        (rv_language_seoulightdetail.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_language_seoulightdetail.adapter = languageAdapter

        // 코스 리사이클러뷰
        courseItems = ArrayList()
        courseItems.add(CourseItem(R.drawable.ic_see_course, "경복궁"))
        courseItems.add(CourseItem(R.drawable.ic_eat_course, "육회맛집"))
        courseItems.add(CourseItem(R.drawable.ic_see_course, "경복궁"))
        courseItems.add(CourseItem(R.drawable.ic_eat_course, "육회맛집"))

        courseAdapter = CourseAdapter(courseItems)
        rv_course_seoulightdetail.layoutManager = LinearLayoutManager(this)
        (rv_course_seoulightdetail.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_course_seoulightdetail.adapter = courseAdapter

        // 리뷰 리사이클러뷰
        reviewItems = ArrayList()
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))

        reviewAdapter = ReviewAdapter(reviewItems)
        rv_review_seoulight.layoutManager = LinearLayoutManager(this)
        rv_review_seoulight.adapter = reviewAdapter

    }
}