package com.hyeran.android.dodobo.mypage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType.*
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_modify.*
import android.widget.RelativeLayout
import android.provider.MediaStore.Images
import android.app.Activity
import android.widget.ImageView
import java.io.FileNotFoundException
import java.io.IOException

/*
갤러리에서 이미지 가져오기 참고 링크
http://ankyu.entersoft.kr/Lecture/android/gallery_01.asp
*/

class ModifyActivity : AppCompatActivity(), View.OnClickListener {

    // 비밀번호 보이기 아이콘 Pressed 상태(0-Unpressed, 1-Pressed)
    var status1 = 0
    var status2 = 0
    // 초기 inputType 저장할 변수
    var inputTypeInvisible = 0

    var REQ_CODE_SELECT_IMAGE = 100;

    override fun onClick(v: View?) {
        when(v) {
            btn_back_modify -> {
                finish()
            }
            btn_changephoto_modify -> {
                // 갤러리 이동
                var intent = Intent(Intent.ACTION_PICK)
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE)
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
            }
            btn_show1_modify -> {
                if(status1 == 0) {  // 비밀번호 보이게
                    status1 = 1
                    et_password1_modify.inputType = TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    et_password1_modify.setSelection(et_password1_modify.text.length)   // 커서 위치 이동
                } else {            // 비밀번호 안보이게
                    status1 = 0
                    et_password1_modify.inputType = inputTypeInvisible
                    et_password1_modify.setSelection(et_password1_modify.text.length)   // 커서 위치 이동
                }
            }
            btn_show2_modify -> {
                if(status2 == 0) {  // 비밀번호 보이게
                    status2 = 1
                    et_password2_modify.inputType = TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    et_password2_modify.setSelection(et_password2_modify.text.length)   // 커서 위치 이동
                } else {            // 비밀번호 안보이게
                    status2 = 0
                    et_password2_modify.inputType = inputTypeInvisible
                    et_password2_modify.setSelection(et_password2_modify.text.length)   // 커서 위치 이동
                }
            }
            btn_applyseoulight_modify -> {
                val intent = Intent(applicationContext, ApplySeoulightActivity::class.java)
                startActivity(intent)
            }
            btn_complete_modify -> {
                lateinit var toastView : RelativeLayout
                // 비밀번호 일치
                if(et_password1_modify.text.toString() == et_password2_modify.text.toString()) {
                    toastView = View.inflate(applicationContext, R.layout.toast_complete_modify, null) as RelativeLayout
                } else {    // 비밀번호 불일치 오류
                    toastView = View.inflate(applicationContext, R.layout.toast_fail_modify, null) as RelativeLayout
                }
                openToast(toastView)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        // 클릭 리스너 등록
        btn_back_modify.setOnClickListener(this)
        btn_changephoto_modify.setOnClickListener(this)
        btn_show1_modify.setOnClickListener(this)
        btn_show2_modify.setOnClickListener(this)
        btn_applyseoulight_modify.setOnClickListener(this)
        btn_complete_modify.setOnClickListener(this)

        // EditText 커서 위치 끝으로 이동
        et_password1_modify.setSelection(et_password1_modify.text.length)
        et_password2_modify.setSelection(et_password2_modify.text.length)

        // INVISIBLE PASSWORD inputType 저장
        inputTypeInvisible = et_password1_modify.inputType

        //TODO btn_applyseoulight_modify    -> 서울라이트가 아닌 경우에만 보이도록
        //TODO icon_seoulight_modify        -> 서울라이트인 경우에만 보이도록
    }

    // 선택한 이미지 데이터 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === REQ_CODE_SELECT_IMAGE) {
            if (resultCode === Activity.RESULT_OK) {
                try {
                    //이미지 데이터를 비트맵으로 받아온다.
                    val image_bitmap = Images.Media.getBitmap(contentResolver, data!!.getData())
                    val image = findViewById(R.id.iv_profile_modify) as ImageView

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

    // 토스트 띄우기
    fun openToast(toastView : RelativeLayout) {
        val toast = Toast(applicationContext)
        toast.view = toastView
        toast.setGravity(Gravity.CENTER, 0, 0)  // 중앙으로 위치 이동(첫번째 인자를 중심으로 xOffset, yOffset 떨어진 곳)
        toast.show()
    }
}
