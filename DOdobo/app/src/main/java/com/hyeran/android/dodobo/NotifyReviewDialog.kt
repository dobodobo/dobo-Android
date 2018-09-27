package com.hyeran.android.dodobo

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import kotlinx.android.synthetic.main.dialog_notify_review.*

class NotifyReviewDialog(activity: Activity) : Dialog(activity) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_notify_review)
        btn_back_notifyreview.setOnClickListener {
            dismiss()
        }
    }
}