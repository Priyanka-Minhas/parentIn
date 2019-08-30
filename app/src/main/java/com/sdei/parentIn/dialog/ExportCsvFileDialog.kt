package com.sdei.parentIn.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.view.Gravity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.AddStudentManullyRequest
import com.sdei.parentIn.utils.getAppPref
import kotlinx.android.synthetic.main.dialog_teacher_add_child.*
import java.util.*

class ExportCsvFileDialog(
        context: Context,
        themeResId: Int,
        val LayoutId: Int) : BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.CENTER
        window!!.attributes = wmlp
    }

    override fun onCreateStuff() {

        /*imgClose.setOnClickListener {
            dismissDialog()
        }*/

       /* btnAddStudent.setOnClickListener {

        }*/


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
