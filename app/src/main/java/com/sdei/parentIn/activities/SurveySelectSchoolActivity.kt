package com.sdei.parentIn.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.SurveySchoolListDialog
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SurveySchoolModel
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.SurveySelectSchoolViewModel
import kotlinx.android.synthetic.main.activity_survey_select_school.*

class SurveySelectSchoolActivity : BaseActivity<SurveySelectSchoolViewModel>(), View.OnClickListener {

    var mSchoolList = arrayListOf<SurveySchoolModel.DataBean>()

    override val layoutId: Int
        get() = R.layout.activity_survey_select_school

    override val viewModel: SurveySelectSchoolViewModel
        get() = ViewModelProviders.of(this).get(SurveySelectSchoolViewModel::class.java)

    override val context: Context
        get() = this@SurveySelectSchoolActivity

    var childId: String = ""

    override fun onCreate() {
        if (connectedToInternet(btnBack)) {
            showProgess()
            mViewModel!!.getSchoolList().observe(this,
                    Observer<SurveySchoolModel> { mData ->
                        if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                            mSchoolList = mData.data!!
                        }
                    })
        }

    }

    override fun initListeners() {
        edtSelectSchool.setOnClickListener(this)
        btnStartQuestion.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.edtSelectSchool -> {
                SurveySchoolListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        mSchoolList,
                        getString(R.string.select_school),
                        InterfacesCall.Callback { pos ->
                            edtSelectSchool.setText(mSchoolList[pos].schoolName)
                            txtChildName.text = mSchoolList[pos].firstName + " " + mSchoolList[pos].lastName
                            childId = mSchoolList[pos]._id.toString()
                        }).show()
            }
            R.id.btnStartQuestion -> {
                if (!TextUtils.isEmpty(childId)) {
                    val intent = Intent(mContext, SurveyActivity::class.java)
                    intent.putExtra(InterConst.CHILD_ID, childId)
                    startActivityForResult(intent, InterConst.RESULT_SURVEY)
                } else {
                    showAlertSnackBar(btnStartQuestion, mContext.getString(R.string.errorSchool))
                }
            }
            R.id.btnBack -> {
                finish()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == InterConst.RESULT_SURVEY) {
                finish()
            }
        }
    }

}
