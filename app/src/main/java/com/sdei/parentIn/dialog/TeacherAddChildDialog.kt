package com.sdei.parentIn.dialog

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.AddStudentManullyRequest
import com.sdei.parentIn.utils.getAppPref
import kotlinx.android.synthetic.main.dialog_teacher_add_child.*
import java.util.*

class TeacherAddChildDialog(
       context: Context,
        themeResId: Int,
        val LayoutId: Int,
        val returnValue: (AddStudentManullyRequest) -> Unit) : BaseDialog(context, themeResId) {



    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity =Gravity.CENTER
        window!!.attributes = wmlp
    }

    override fun onCreateStuff() {
        btnAddStudent.setOnClickListener{
            var  mData=AddStudentManullyRequest()

            mData.firstName = edtParentFirstName.text.toString()
            mData.lastName =  edtParentLastName.text.toString()
            mData.emailAddress = edtParentEmail.text.toString()

            // add child
            mData.child=AddStudentManullyRequest.DataBean()
            mData.child!!.firstName = edtChildFirstName.text.toString()
            mData.child!!.lastName = edtChildLastName.text.toString()
            mData.child!!.birthDate = edtChildBirthDate.text.toString()
            mData.child!!.verificationCard = edtChildIdentityCard.text.toString()
            mData.child!!.school = getAppPref()!!.getInt(InterConst.STUDENT_ID).toString()
            mData.child!!.teacher= getAppPref()!!.getInt(InterConst.ROLE_ID).toString()
            this.returnValue(mData)
        }

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
