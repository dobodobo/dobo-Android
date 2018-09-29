package com.hyeran.android.dodobo.dobo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hyeran.android.dodobo.AddReviewDialog
import com.hyeran.android.dodobo.ImgSlideAdapter
import com.hyeran.android.dodobo.NotifyReviewDialog
import com.hyeran.android.dodobo.recyclerview.course.CourseAdapter
import com.hyeran.android.dodobo.recyclerview.course.CourseItem
import com.hyeran.android.dodobo.recyclerview.review.ReviewAdapter
import com.hyeran.android.dodobo.recyclerview.review.ReviewItem
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recyclerview.surrounding.SurroundingAdapter
import com.hyeran.android.dodobo.recyclerview.surrounding.SurroundingItem
import kotlinx.android.synthetic.main.activity_dobo_detail.*

/*
이미지 슬라이더 참고 링크
http://debuglog.tistory.com/63

뷰페이저 넘어갈때 마다 이벤트 정의 참고 링크
https://code.i-harness.com/ko-kr/q/142863a
 */
class DoboDetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
       NotifyReviewDialog(this).show()
    }

    // 이미지 슬라이더 사용 변수
    lateinit var imgSlideAdapter : ImgSlideAdapter
    lateinit var viewPager : ViewPager
//    lateinit var pageChangeListener : ViewPager.OnPageChangeListener

    lateinit var courseItems : ArrayList<CourseItem>
    lateinit var courseAdapter : CourseAdapter

    lateinit var surroundingItems : ArrayList<SurroundingItem>
    lateinit var surroundingAdapter: SurroundingAdapter

    lateinit var  reviewItems : ArrayList<ReviewItem>
    lateinit var  reviewAdapter : ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dobo_detail)

        // 이미지 슬라이더
        viewPager = findViewById(R.id.vp_img_dobodetail)
        imgSlideAdapter = ImgSlideAdapter(this)
        viewPager.adapter = imgSlideAdapter

//        // 뷰페이저 넘어갈때 마다 이벤트 정의
//        pageChangeListener = object : OnPageChangeListener {
//
//            override fun onPageSelected(position: Int) {
//                iv_dot1_dobodetail.setImageResource(R.drawable.oval_2_copy)
//                iv_dot1_dobodetail.setImageResource(R.drawable.oval_2)
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
//            override fun onPageScrollStateChanged(state: Int) {}
//        }

//        viewPager.addOnPageChangeListener(pageChangeListener)



        btn_back_dobodetail.setOnClickListener {
            finish()
        }

        btn_addreview_dobo.setOnClickListener {
            AddReviewDialog(this).show()
        }

        // 코스 리사이클러뷰
        courseItems = ArrayList()
        courseItems.add(CourseItem(R.drawable.ic_see_course, "경복궁"))
        courseItems.add(CourseItem(R.drawable.ic_eat_course, "육회맛집"))
        courseItems.add(CourseItem(R.drawable.ic_see_course, "경복궁"))
        courseItems.add(CourseItem(R.drawable.ic_eat_course, "육회맛집"))

        courseAdapter = CourseAdapter(courseItems)
        rv_course_dobodetail.layoutManager = LinearLayoutManager(this)
        (rv_course_dobodetail.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_course_dobodetail.adapter = courseAdapter

        // 주변관광지 리사이클러뷰
        surroundingItems = ArrayList()
        surroundingItems.add(SurroundingItem(R.drawable.home, "맛집이지롱", R.drawable.ic_fork, "식음료"))
        surroundingItems.add(SurroundingItem(R.drawable.home, "맛집이지롱", R.drawable.ic_fork, "식음료"))
        surroundingItems.add(SurroundingItem(R.drawable.home, "맛집이지롱", R.drawable.ic_fork, "식음료"))
        surroundingItems.add(SurroundingItem(R.drawable.home, "맛집이지롱", R.drawable.ic_fork, "식음료"))

        surroundingAdapter = SurroundingAdapter(surroundingItems)
        rv_surrounding_dobodetail.layoutManager = LinearLayoutManager(this)
        (rv_surrounding_dobodetail.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_surrounding_dobodetail.adapter = surroundingAdapter

        // 리뷰 리사이클러뷰
        reviewItems = ArrayList()
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "여긴 도보다!!!! 정말 멋진 산책~! 리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))
        reviewItems.add(ReviewItem("신혜란", "2018.09.23", "리뷰리뷰 아주 좋아요!"))
        reviewItems.add(ReviewItem("신지은", "2018.09.23", "푸핫 아주 좋은 곳이네요!"))

        reviewAdapter = ReviewAdapter(reviewItems)
        reviewAdapter.setOnItemClickListener(this)
        rv_review_dobodetail.layoutManager = LinearLayoutManager(this)
        rv_review_dobodetail.adapter = reviewAdapter
    }


}
