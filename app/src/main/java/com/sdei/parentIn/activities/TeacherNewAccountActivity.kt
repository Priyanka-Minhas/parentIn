package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.dialog.SchoolListDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_teacher_new_account.*

class TeacherNewAccountActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener {
    var mSchoolList = arrayListOf<SchoolModel.DataBean>()

    override val layoutId: Int
        get() = R.layout.activity_teacher_new_account
    override val viewModel: ParentNewAccountViewModel
        get() = ViewModelProviders.of(this).get(ParentNewAccountViewModel::class.java)
    override val context: Context
        get() = this@TeacherNewAccountActivity

    override fun onCreate() {
        // get school list
        mViewModel!!.getSchoolList().observe(this,
                Observer<SchoolModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        mSchoolList.addAll(mData.data!!)
                    }
                })

        mViewModel!!.getProfile().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.registered_successfully))
                        finish()
                    }
                })
    }

    override fun initListeners() {
      btnBack.setOnClickListener(this)
      btnCreateTeachAccount.setOnClickListener(this)
      edtTeacherGender.setOnClickListener(this)
        edtTeacherSchool.setOnClickListener(this)
        edtTeacherNumberOfStu.setOnClickListener(this)
        edtTeacherLevelOfEducation.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnCreateTeachAccount->{
                if(!edtTeacherFirstName.nonEmpty()){
                   showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorFirstName))
                }else if(!edtTeacherLastName.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorLastName))
                }else if(!edtTeacherGender.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorGender))
                }else if(!edtTeacherIdCard.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorIdentification))
                }else if(!edtTeacherSchool.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorSchool))
                }else if(!edtTeacherNumberOfStu.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorNoOfSchools))
                }else if(!edtTeacherLevelOfEducation.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorLevelOfEducation))
                }else if(!edtTeacherEmail.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorEmail))
                }else if(!edtTeacherEmail.validEmail()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorValidEmail))
                }else if(!edtTeacherConfMail.text.toString().equals(edtTeacherEmail.text.toString())){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorConfEmail))
                }else if(!edtTeacherPass.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorValidPassword))
                } else if(!edtTeacherConfPass.nonEmpty()){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorConfirmPassword))
                } else if(!edtTeacherPass.text.toString().equals(edtTeacherConfPass.text.toString())){
                    showAlertSnackBar(btnCreateTeachAccount,getString(R.string.errorConfirmPassword))
                }else{
                    val model = UserModel.DataBean()
                    model._id =""
                    model.firstName = edtTeacherFirstName.text.toString()
                    model.lastName = edtTeacherLastName.text.toString()
                    model.phoneNumber=""
                    model.relationWithChild=""
                    model.homeAddress=""
                    model.isIsSameAddressAsStudent = true
                    model.levelOfEducation = edtTeacherLevelOfEducation.text.toString()
                    model.noOfStudents = edtTeacherNumberOfStu.text.toString().toInt()
                    model.emailAddress = edtTeacherEmail.text.toString()
                    model.password = edtTeacherPass.text.toString()
                    model.roleId =3
                    model.__v =1

                    if (connectedToInternet(btnCreateTeachAccount)) {
                        showProgess()
                        mViewModel!!.setProfile(model)
                    }
                }
            }
            R.id.edtTeacherSchool ->{
                SchoolListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        mSchoolList,
                        getString(R.string.select_school),InterfacesCall.Callback { pos ->
                          edtTeacherSchool.setText(mSchoolList[pos].schoolName.toString())
                        }).show()

            }

            R.id.edtTeacherGender ->{
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getGender(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtTeacherGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtTeacherNumberOfStu ->{
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getNoOfStudents(),
                        getString(R.string.select_no_of_student),
                        InterfacesCall.Callback { pos ->
                            edtTeacherNumberOfStu.setText(getNoOfStudents()[pos].name.toString())
                        }).show()
            }

            R.id.edtTeacherLevelOfEducation ->{
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getLevelOfEducation(),
                        getString(R.string.select_level_of_education),
                        InterfacesCall.Callback { pos ->
                            edtTeacherLevelOfEducation.setText(getLevelOfEducation()[pos].name.toString())
                        }).show()
            }

           R.id.btnBack->{
               finish()
           }
        }
    }

}
