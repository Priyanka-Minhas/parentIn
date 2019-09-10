package com.sdei.parentIn.activities.parent

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.dialog.OptionListDialog
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.BaseViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_parents_new_account.*

class ParentsRegisterActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_parents_new_account
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@ParentsRegisterActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        edtGender.setOnClickListener(this)
        edtRelationshipChild.setOnClickListener(this)
        edtLevelOfEducation.setOnClickListener(this)
        edtNoOfStudent.setOnClickListener(this)
        btnFollow.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.edtGender -> {
                OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getGender(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtRelationshipChild -> {
                OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getRelations(),
                        getString(R.string.select_relation),
                        InterfacesCall.Callback { pos ->
                            edtRelationshipChild.setText(getRelations()[pos].name.toString())
                        }).show()
            }

            R.id.edtLevelOfEducation -> {
                OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getLevelOfEducation(),
                        getString(R.string.select_level_of_education),
                        InterfacesCall.Callback { pos ->
                            edtLevelOfEducation.setText(getLevelOfEducation()[pos].name.toString())
                        }).show()
            }

            R.id.edtNoOfStudent -> {
                OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getNoOfStudents(),
                        getString(R.string.select_no_of_student),
                        InterfacesCall.Callback { pos ->
                            edtNoOfStudent.setText(getNoOfStudents()[pos].name.toString())
                        }).show()
            }

            R.id.btnFollow -> {
                if (edtFirstName.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorFirstName))
                } else if (edtLastName.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorLastName))
                } else if (edtEmail.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorEmail))
                } else if (!edtEmail.validEmail()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidEmail))
                } else if (edtPassword.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidPassword))
                } else if (edtConfPassword.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorEnterConfPass))
                } else if (edtConfPassword.text.toString() != edtPassword.text.toString()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorConfirmPassword))
                } else if (edtAddress.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorAddress))
                } else if (edtGender.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorGender))
                } else if (edtRelationshipChild.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorRelationship))
                } else if (edtId.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorIdentification))
                }  else if (edtLevelOfEducation.text.trim().toString().isEmpty()) {
                    showAlertSnackBar(btnFollow, getString(R.string.errorLevelOfEducation))
                } else if (edtNoOfStudent.text.trim().toString().isEmpty()) {
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
        val model = UserModel.DataBeanRequest()

        model.firstName = edtFirstName.text.toString()
        model.lastName = edtLastName.text.toString()
        model.emailAddress = edtEmail.text.toString()
        model.homeAddress = edtAddress.text.toString()
        model.relationWithChild = edtRelationshipChild.text.toString()
        model.levelOfEducation = edtLevelOfEducation.text.toString()
        model.verificationCard = edtId.text.toString()
        model.password = edtPassword.text.toString()
        model.confirmPassword = edtConfPassword.text.toString()
        model.gender = getGender(edtGender.text.toString())
        model.roleId = getAppPref().getInt(InterConst.ROLE_ID)

        val intent = Intent(mContext, ParentAddChildActivity::class.java)
        intent.putExtra(InterConst.PARENT_DATA, model)
        startActivity(intent)
    }

}
