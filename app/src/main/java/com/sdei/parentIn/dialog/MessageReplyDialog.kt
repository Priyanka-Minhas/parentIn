package com.sdei.parentIn.dialog

import android.content.Context
import android.view.Gravity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.getFormatDate
import kotlinx.android.synthetic.main.dialog_reply_message.*

class MessageReplyDialog(context: Context,
                         themeResId: Int,
                         val LayoutId: Int,
                         val model: MessagesModel.DataBean,
                         val mClick: IndexClick) : BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.BOTTOM
        window!!.attributes = wmlp
    }


    override fun onCreateStuff() {
        imgClose.setOnClickListener {
            dismissDialog()
        }

        if (getAppPref().getString(InterConst.ID) != model.from) {
            txtName.text = model.fromName.toString()
        } else {
            txtName.text = model.toName.toString()
        }

        txtDescription.text = model.message.toString()
        txtDate.text = context.getFormatDate(model.createdAt.toString())

        imgSend.setOnClickListener {
            mClick.clickIndex(editText.text.toString())
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

    interface IndexClick {
        fun clickIndex(message: String)
    }

}