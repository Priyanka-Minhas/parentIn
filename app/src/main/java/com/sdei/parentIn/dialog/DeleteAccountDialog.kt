package com.sdei.parentIn.dialog

import android.content.Context
import android.view.Gravity
import android.view.View
import com.sdei.parentIn.R
import com.sdei.parentIn.interfaces.InterfacesCall
import kotlinx.android.synthetic.main.delete_account.*

class DeleteAccountDialog(
        context: Context,
        themeResId: Int,
        val LayoutId: Int,
        val title: String,
        val message: String, private val callback: InterfacesCall.BtnClick) : BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.CENTER
        window!!.attributes = wmlp
    }

    override fun onCreateStuff() {
        txtDialogTitle.text = title
        txtDialogMsg.text = message

        txtCancel.setOnClickListener {
            dismissDialog()
        }

        txtRemove.setOnClickListener {
          //callback.onClick()
            layoutButton.visibility = View.GONE
            txtAccept.visibility = View.VISIBLE

            txtDialogTitle.text = context.getString(R.string.cuenta_eliminada)
            txtDialogMsg.text =context.getText(R.string.account_delete_msg)
        }

        txtAccept.setOnClickListener {
            callback.onClick()
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
