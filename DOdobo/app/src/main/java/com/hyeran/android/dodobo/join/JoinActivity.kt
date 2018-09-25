package com.hyeran.android.dodobo.join

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.login.LoginActivity
import kotlinx.android.synthetic.main.activity_join.*
import java.io.FileNotFoundException
import java.io.IOException
import java.util.regex.Matcher
import java.util.regex.Pattern

class JoinActivity : AppCompatActivity() {

    var REQ_CODE_SELECT_IMAGE = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        btn_changephoto_join.setOnClickListener{
            changePhoto()
        }
        btn_finish_join.setOnClickListener{
            // 모든 항목 입력한지 확인
            if(et_email_jogin.text.toString() == "" || et_name_jogin.text.toString() == "" ||
                    et_password_jogin.text.toString() == "" || et_passwordcheck_jogin.text.toString() == "") {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                // 이메일 형식 확인
                if(checkEmail(et_email_jogin.text.toString())) {
                    // 비밀번호 불일치 하는지 확인
                    if (et_password_jogin.text.toString() != et_passwordcheck_jogin.text.toString()) {
                        et_passwordcheck_jogin.setBackgroundResource(R.drawable.login_textbox_error)
                        Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "회원가입을 축하합니다.", Toast.LENGTH_SHORT).show()
                        var intent = Intent(baseContext, LoginActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, "올바른 이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // 이메일 포맷 확인
    fun checkEmail(email : String) : Boolean {
        var regex : String = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"
        var p : Pattern = Pattern.compile(regex)
        var m : Matcher = p.matcher(email)
        var isNormal : Boolean = m.matches()
        return isNormal
    }

    // 갤러리에서 이미지 가져오기
    fun changePhoto() {
        var intent = Intent(Intent.ACTION_PICK)
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE)
        intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
    }

    // 선택한 이미지 데이터 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === REQ_CODE_SELECT_IMAGE) {
            if (resultCode === Activity.RESULT_OK) {
                try {
                    //이미지 데이터를 비트맵으로 받아온다.
                    val image_bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.getData())
                    val image = findViewById(R.id.iv_profile_join) as ImageView

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
}
