package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.SchoolListListDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.room.RoomDb

import com.sdei.parentIn.viewModel.BaseViewModel

import kotlinx.android.synthetic.main.activity_verify_school.*

class VerifySchoolActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {

    var mSchoolList = arrayListOf<SchoolModel.DataBean>()
    var schoolId : String? =null
    override val layoutId: Int
        get() = R.layout.activity_verify_school
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@VerifySchoolActivity

    override fun onCreate() {
        mSchoolList =  RoomDb.getInstance(application).noteDao().fetchSchoolList() as ArrayList<SchoolModel.DataBean>

    }

    override fun initListeners() {
        edtSelectSchool.setOnClickListener(this)
        btnStartQuestion.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
           R.id.edtSelectSchool -> {
               SchoolListListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                       mSchoolList,
                       getString(R.string.select_school),
                       InterfacesCall.Callback { pos ->
                        edtSelectSchool.setText(mSchoolList[pos].schoolName)
                          schoolId = mSchoolList[pos]._id
                       }).show()
           }
           R.id.btnStartQuestion ->{

           }
        }

    }
}
