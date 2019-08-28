package com.sdei.parentIn.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.dialog_teacher_add_child.*
import java.util.*

class TeacherAddChildDialog(
        context: Context,
        themeResId: Int,
        private val LayoutId: Int
) : BaseDialog(context, themeResId) {

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        window!!.attributes = wmlp
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateStuff() {

        edtChildBirthDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Display Selected date in Toast
                val date = "$year/${monthOfYear + 1}/$dayOfMonth"
                edtChildBirthDate.setText(date)

            }, year, month, day)

            dpd.show()
        }

    }

    override fun getContentView(): Int {
        return LayoutId
    }

}
