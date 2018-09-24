package com.hyeran.android.dodobo.join

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.login.LoginActivity
import kotlinx.android.synthetic.main.activity_join.*
import java.io.FileNotFoundException
import java.io.IOException

class JoinActivity : AppCompatActivity() {

    var REQ_CODE_SELECT_IMAGE = 100;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        btn_changephoto_join.setOnClickListener{
            // 갤러리 이동
            var intent = Intent(Intent.ACTION_PICK)
            intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE)
            intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
        }
        btn_finish_join.setOnClickListener{
            var intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
        }
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
