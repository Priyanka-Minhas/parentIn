package com.sdei.parentIn.activities.teacher

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.activities.WelcomeActivity
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.dialog.SchoolListDialog
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.teacher.TeacherRegisterViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_teacher_new_account.*

class TeacherRegisterActivity : BaseActivity<TeacherRegisterViewModel>(), View.OnClickListener {
    var mSchoolList = arrayListOf<SchoolModel.DataBean>()

    override val layoutId: Int
        get() = R.layout.activity_teacher_new_account
    override val viewModel: TeacherRegisterViewModel
        get() = ViewModelProviders.of(this).get(TeacherRegisterViewModel::class.java)
    override val context: Context
        get() = this@TeacherRegisterActivity

    override fun onCreate() {
        // get school list
        mViewModel!!.getSchoolList().observe(this,
                Observer<ArrayList<SchoolModel.DataBean>> { mData ->
                        mSchoolList.addAll(mData)
                })

        mViewModel!!.getProfile().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.registered_successfully))

                        val intent = Intent(mContext, WelcomeActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    }
                })
    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        btnCreateAccount.setOnClickListener(this)
        edtGender.setOnClickListener(this)
        edtSchool.setOnClickListener(this)
        edtNumberOfStu.setOnClickListener(this)
        edtLevelOfEducation.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnCreateAccount -> {
                if (!edtFirstName.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorFirstName))
                } else if (!edtLastName.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorLastName))
                } else if (!edtGender.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorGender))
                } else if (!edtId.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorIdentification))
                } else if (!edtSchool.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorSchool))
                } else if (!edtNumberOfStu.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorNoOfSchools))
                } else if (!edtLevelOfEducation.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorLevelOfEducation))
                } else if (!edtEmail.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorEmail))
                } else if (!edtEmail.validEmail()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorValidEmail))
                } else if (!edtConfMail.text.toString().equals(edtEmail.text.toString())) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorConfEmail))
                } else if (!edtPassword.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorValidPassword))
                } else if (!edtConfPassword.nonEmpty()) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorConfirmPassword))
                } else if (!edtPassword.text.toString().equals(edtConfPassword.text.toString())) {
                    showAlertSnackBar(btnCreateAccount, getString(R.string.errorConfirmPassword))
                } else {
                    setData()
                }
            }
            R.id.edtSchool -> {
                SchoolListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        mSchoolList,
                        getString(R.string.select_school), InterfacesCall.Callback { pos ->
                    edtSchool.setText(mSchoolList[pos].schoolName.toString())
                }).show()

            }

            R.id.edtGender -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getGender(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtNumberOfStu -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getNoOfStudents(),
                        getString(R.string.select_no_of_student),
                        InterfacesCall.Callback { pos ->
                            edtNumberOfStu.setText(getNoOfStudents()[pos].name.toString())
                        }).show()
            }

            R.id.edtLevelOfEducation -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getLevelOfEducation(),
                        getString(R.string.select_level_of_education),
                        InterfacesCall.Callback { pos ->
                            edtLevelOfEducation.setText(getLevelOfEducation()[pos].name.toString())
                        }).show()
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }

    private fun setData() {
        val model = UserModel.DataBeanRequest()

        model.firstName = edtFirstName.text.toString()
        model.lastName = edtLastName.text.toString()
        model.levelOfEducation = edtLevelOfEducation.text.toString()
        model.noOfStudents = edtNumberOfStu.text.toString()
        model.emailAddress = edtEmail.text.toString()
        model.confirmEmail = edtConfMail.text.toString()
        model.password = edtPassword.text.toString()
        model.confirmPassword = edtConfPassword.text.toString()
        model.school = edtSchool.text.toString()
        model.gender = edtGender.text.toString()
        model.verificationCard = edtId.text.toString()
        model.roleId = getAppPref().getInt(InterConst.ROLE_ID)

        if (connectedToInternet(btnCreateAccount)) {
            showProgess()
            mViewModel!!.setProfile(model)
        }
    }


}
