package com.hyeran.android.dodobo

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import kotlinx.android.synthetic.main.dialog_review_register.*

class AddReviewDialog(activity: Activity) : Dialog(activity) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_review_register)
        btn_back_reviewregister.setOnClickListener {
            dismiss()
        }
    }
}