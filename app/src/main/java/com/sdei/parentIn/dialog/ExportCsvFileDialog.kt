package com.sdei.parentIn.dialog

import android.content.Context
import android.view.Gravity
import com.sdei.parentIn.interfaces.InterfacesCall
import kotlinx.android.synthetic.main.dialog_export_csv.*

class ExportCsvFileDialog(
        context: Context,
        themeResId: Int,
        val LayoutId: Int,
        private val callback: InterfacesCall.BtnClick) : BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.CENTER
        window!!.attributes = wmlp
    }

    override fun onCreateStuff() {

        txtCancel.setOnClickListener {
            dismissDialog()
        }

        txtExport.setOnClickListener {
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
