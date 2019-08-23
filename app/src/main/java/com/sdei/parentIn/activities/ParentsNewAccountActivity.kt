package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.BaseViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_parents_new_account.*

class ParentsNewAccountActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {

    var isSameAddressAsStudent: Boolean = true

    override val layoutId: Int
        get() = R.layout.activity_parents_new_account
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@ParentsNewAccountActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        edtGender.setOnClickListener(this)
        edtRelationshipChild.setOnClickListener(this)
        edtLevelOfEducation.setOnClickListener(this)
        edtNoOfStudent.setOnClickListener(this)
        btnFollow.setOnClickListener(this)
        btnBack.setOnClickListener(this)
        rgYesNo.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbYes -> {
                    isSameAddressAsStudent = true
                }
                R.id.rbNo -> {
                    isSameAddressAsStudent = false
                }
            }
        }
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.edtGender -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getGender(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtRelationshipChild -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getRelations(),
                        getString(R.string.select_relation),
                        InterfacesCall.Callback { pos ->
                            edtRelationshipChild.setText(getRelations()[pos].name.toString())
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

            R.id.edtNoOfStudent -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getNoOfStudents(),
                        getString(R.string.select_no_of_student),
                        InterfacesCall.Callback { pos ->
                            edtNoOfStudent.setText(getNoOfStudents()[pos].name.toString())
                        }).show()
            }
            R.id.btnFollow -> {
                if (!edtFirstName.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorFirstName))
                } else if (!edtLastName.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorLastName))
                }else if(!edtEmail.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorEmail))
                } else if (!edtEmail.validEmail()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidEmail))
                } else if (!edtPassword.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidPassword))
                }else if(!edtConfPassword.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorEnterConfPass))
                } else if (!edtConfPassword.text.toString().equals(edtPassword.text.toString())) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorConfirmPassword))
                } else if (!edtAddress.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorAddress))
                } else if (!edtGender.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorGender))
                } else if (!edtRelationshipChild.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorRelationship))
                } else if (!edtId.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorIdentification))
                } else if (rgYesNo.checkedRadioButtonId == -1) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorStudentAddress))
                } else if (!edtLevelOfEducation.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorLevelOfEducation))
                } else if (!edtNoOfStudent.nonEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorNoOfSchools))
                } else {
                   sendDataToNext()
                }

            }
            R.id.btnBack -> {
                finish()
            }
        }
    }

    private fun sendDataToNext() {
        val model = UserModel.DataBean()

        model.firstName = edtFirstName.text.toString()
        model.lastName = edtLastName.text.toString()
        model.emailAddress = edtEmail.text.toString()
        model.password = edtPassword.text.toString()
        model.homeAddress = edtAddress.text.toString()
        model.relationWithChild = edtRelationshipChild.text.toString()

//      model._id = edtId.text.toString()
//      model._id = edtGender.text.toString()

        model.relationWithChild = edtRelationshipChild.text.toString()
        if (rbYes.isEnabled) {
            model.isIsSameAddressAsStudent = true
        } else {
            model.isIsSameAddressAsStudent = true
        }
        model.levelOfEducation = edtLevelOfEducation.text.toString()
        model.noOfStudents = edtNoOfStudent.text.toString().toInt()

        val intent = Intent(mContext, ParentAddChildActivity::class.java)
        intent.putExtra(InterConstants.EXTRA_DATA, model)
        startActivity(intent)
    }


}
