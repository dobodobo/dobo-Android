package com.hyeran.android.dodobo

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.dialog_notify_review.*

class NotifyReviewDialog(activity: Activity) : Dialog(activity) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_notify_review)
        btn_back_notifyreview.setOnClickListener {
            dismiss()
        }
        linear_notify_review.setOnClickListener {
            Toast.makeText(context, "신고가 접수되었습니다.", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}