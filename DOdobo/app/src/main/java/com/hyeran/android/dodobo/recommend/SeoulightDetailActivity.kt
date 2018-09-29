package com.hyeran.android.dodobo.recommend

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.hyeran.android.dodobo.AddReviewDialog
import com.hyeran.android.dodobo.ImgSlideAdapter
import com.hyeran.android.dodobo.NotifyReviewDialog
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recyclerview.course.CourseAdapter
import com.hyeran.android.dodobo.recyclerview.course.CourseItem
import com.hyeran.android.dodobo.recyclerview.language.LanguageAdapter
import com.hyeran.android.dodobo.recyclerview.language.LanguageItem
import com.hyeran.android.dodobo.recyclerview.review.ReviewAdapter
import com.hyeran.android.dodobo.recyclerview.review.ReviewItem
import kotlinx.android.synthetic.main.activity_seoulight_detail.*
/*
이미지 슬라이더 참고 링크
http://debuglog.tistory.com/63

이메일 연결 참고 링크
http://purplecowd.tistory.com/entry/android-email-%EB%B3%B4%EB%82%B4%EA%B8%B0-%ED%8C%8C%EC%9D%BC%EC%B2%A8%EB%B6%80-%ED%8F%AC%ED%95%A8
 */
class SeoulightDetailActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        NotifyReviewDialog(this).show()
    }

    // 이미지 슬라이더 사용 변수
    lateinit var imgSliderAdapter : ImgSlideAdapter
    lateinit var viewPager : ViewPager

    lateinit var  languageItems : ArrayList<LanguageItem>
    lateinit var languageAdapter : LanguageAdapter

    lateinit var courseItems : ArrayList<CourseItem>
    lateinit var courseAdapter : CourseAdapter

    lateinit var  reviewItems : ArrayList<ReviewItem>
    lateinit var  reviewAdapter : ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seoulight_detail)

        // 이미지 슬라이더
        viewPager = findViewById(R.id.vp_img_seoulightdetail)
        imgSliderAdapter = ImgSlideAdapter(this)
        viewPager.adapter = imgSliderAdapter

        btn_back_seoulightdetail.setOnClickListener {
            finish()
        }
        btn_addreview_seoulight.setOnClickListener {
            AddReviewDialog(this).show()
        }
        // 이메일 보내기
        btn_ask_seoulight.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setType("plain/text")
            var address: Array<String> = arrayOf("*통신* 해설사 이메일 주소 넣기")
            intent.putExtra(Intent.EXTRA_EMAIL, address)
            startActivity(intent)
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
        reviewAdapter.setOnItemClickListener(this)
        rv_review_seoulight.layoutManager = LinearLayoutManager(this)
        rv_review_seoulight.adapter = reviewAdapter

    }
}