package com.hyeran.android.dodobo.recommend

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import android.widget.Spinner
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.recyclerview.course.CourseAdapter
import kotlinx.android.synthetic.main.activity_course_enroll.*
import java.io.FileNotFoundException
import java.io.IOException

/*
갤러리에서 이미지 가져오기 참고 링크
http://ankyu.entersoft.kr/Lecture/android/gallery_01.asp
스피너 커스텀 이미지뷰 참고 링크
http://blog.naver.com/PostView.nhn?blogId=newyorkinms&logNo=220760844250&parentCategoryNo=10&categoryNo=&viewDate=&isShowPopularPosts=true&from=search
*/

class CourseEnrollActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var icons : ArrayList<CourseSpinner>
    lateinit var courseSpinnerAdapter: CourseSpinnerAdapter

    var REQ_CODE_SELECT_IMAGE = 100;

    override fun onClick(v: View?) {
        when(v) {
            btn_culture_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_culture_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_culture_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_history_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_history_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_history_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_festival_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_festival_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_festival_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_food_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_food_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_food_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_activity_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_activity_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_activity_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_etc_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_etc_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_etc_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_back_courseenroll -> {
                finish()
            }
            btn_addphoto_courseenroll -> {
                // 갤러리 이동
                var intent = Intent(Intent.ACTION_PICK)
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE)
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
            }
            et_coursename_courseenroll -> {
//                var intent = Intent(PlaceAutocomplete.IntentBuilder(PlaceAutocomplete))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_enroll)

        btn_back_courseenroll.setOnClickListener(this)
        btn_culture_courseenroll.setOnClickListener(this)
        btn_history_courseenroll.setOnClickListener(this)
        btn_festival_courseenroll.setOnClickListener(this)
        btn_food_courseenroll.setOnClickListener(this)
        btn_activity_courseenroll.setOnClickListener(this)
        btn_etc_courseenroll.setOnClickListener(this)
        btn_addphoto_courseenroll.setOnClickListener(this)
        et_coursename_courseenroll.setOnClickListener(this)

        icons = ArrayList()
        icons.add(CourseSpinner(R.drawable.ic_see_course))
        icons.add(CourseSpinner(R.drawable.ic_eat_course))

        courseSpinnerAdapter = CourseSpinnerAdapter(applicationContext, icons)
        var spinner : Spinner = findViewById(R.id.spinner_course)
        spinner.adapter = courseSpinnerAdapter

    }

    // 선택한 이미지 데이터 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === REQ_CODE_SELECT_IMAGE) {
            if (resultCode === Activity.RESULT_OK) {
                try {
                    //이미지 데이터를 비트맵으로 받아온다.
                    val image_bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.getData())
                    val image = findViewById(R.id.iv_photo_courseenroll) as ImageView

                    //배치해놓은 ImageView에 set
                    image.setImageBitmap(image_bitmap)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun selected(v: View?) {
        if(!v!!.isSelected) {
            v!!.isSelected = true
            v!!.setBackgroundResource(R.drawable.rectangle_7)
        } else {
            v!!.isSelected = false
            v!!.setBackgroundResource(R.drawable.rectangle_7_copy)
        }
    }

}