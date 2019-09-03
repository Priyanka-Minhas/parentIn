package com.sdei.parentIn.dialog

import android.content.Context
import android.view.Gravity
import kotlinx.android.synthetic.main.dialog_message.*

class MessageDialog(context: Context,
                    themeResId: Int,
                    val LayoutId: Int ):BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.BOTTOM
        window!!.attributes = wmlp
    }


    override fun onCreateStuff() {
        imgClose.setOnClickListener {
            dismissDialog()
        }

    }

    override fun getContentView(): Int {
       return LayoutId
    }

    fun showDialog() {
        if (this.isShowing) {
            return
        } else {
            this.show()
        }

    }

    fun dismissDialog() {
        if (this.isShowing) {
            this.dismiss()
        } else {
            return
        }

    }
}